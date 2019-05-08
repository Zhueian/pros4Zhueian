package cn.zhueian.highConcurrentMultithreading.shibingMa.billbill_mashibing.step02.interview_productAndCutsom;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: qiucy
 * @Date: 2019-04-24 11:03
 * @Description:
 *  用wait/notify非常基础，很low，像是写个商场平台用汇编写一样。
 *  用lock_condition,效率也比notifyAll高，精确唤醒一堆生产者或消费者,而不是二话不说叫醒所有等待线程。
 *  TODO 请写出精确哪一个线程而不是哪一堆线程？
 *
 *  注意：condition.await()和object.wait()没区别，但是Object是基类，同名会重写方法。
 */
public class MyContainer_Condition<T> {
    private final LinkedList<T> list = new LinkedList<>();
    private final int MAX_VAL = 10;
    private int count;

    public int getCount() {
        return count;
    }

    private final Lock lock = new ReentrantLock();
    Condition product = lock.newCondition();
    Condition custom = lock.newCondition();

    public void put(T t){
        System.out.println(Thread.currentThread().getName() + " start..");
        lock.lock();
        try{
            while (MAX_VAL == list.size()){
                product.await();
            }
            System.out.println(Thread.currentThread().getName() + " running..");
            ++count;
            list.add(t);
            custom.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println(Thread.currentThread().getName() + " end..");
            lock.unlock();
        }
    }

    public T get(){
        System.out.println(Thread.currentThread().getName() + " start..");
        T t = null;
        lock.lock();
        try {
            while (0 == list.size()){
                custom.await();
            }
            System.out.println(Thread.currentThread().getName() + " running..");
            count --;
            t = list.removeFirst();
            product.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println(Thread.currentThread().getName() + " end..");
            lock.unlock();
        }
        return t;
    }

    public static void main(String[] args) {
        int flag = 0;
        MyContainer_Condition<String> container = new MyContainer_Condition<>();
        for (int i = 1; i < 3; i++) {
            new Thread(() -> {
                while(true) {
                    container.put("bean");
                }
            },"custom_"+i).start();
        }
        for (int i = 1; i < 11; i++) {
            new Thread(() -> {
                while (true) System.out.println(container.get());
            },"product_"+i).start();
        }
    }
}
