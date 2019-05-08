package cn.zhueian.highConcurrentMultithreading.shibingMa.billbill_mashibing.step02.interview_productAndCutsom;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: qiucy
 * @Date: 2019-04-24 12:05
 * @Description:老马的lock_condition源码
 */
public class MyContainer02_mashibingSrc<T> {
    final private LinkedList<T> list = new LinkedList<>();
    final private int MAX = 10;
    private int count = 0;

    public int getCount() {
        return count;
    }

    private Lock lock = new ReentrantLock();
    private Condition producter = lock.newCondition();
    private Condition consumer = lock.newCondition();

    public void put(T t){
        try{
            lock.lock();
            while (MAX == list.size()){
                producter.await();
            }
            list.add(t);
            ++count;
            consumer.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public T get(){
        T t = null;
        try {
            lock.lock();
            while (0 == list.size()){
                consumer.await();
            }
            t = list.removeFirst();
            --count;
            producter.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
        return t;
    }

    public static void main(String[] args) {
        MyContainer02_mashibingSrc<String> c = new MyContainer02_mashibingSrc<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    System.out.println(Thread.currentThread().getName()+" get and " + c.get());
                }
            },"c"+i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 25; j++) {
                    c.put(Thread.currentThread().getName()+" = "+j);
                }
            },"p"+i).start();
        }
    }
}
