package cn.zhueian.highConcurrentMultithreading.shibingMa.msb.step02.interview_productAndCutsom;

import java.util.LinkedList;

/**
 * @Auther: qiucy
 * @Date: 2019-04-24 09:41
 * @Description:面试题：
 *  写一固定容量的容器，暴露put(Object o),get(),getCount();
 *  能支持2个生产者和10个消费者阻塞调用；
 *  用wait/notify实现。
 */
public class MyContainer01<T> {

    //TODO src有bug我操
    //get put肯定要加锁，不然会超生和超卖，getCount也加锁
    //满了put得阻塞，空了get要阻塞
    private /*final*/ volatile LinkedList<T> list = new LinkedList<>();
//    private final LinkedList<T> list = new LinkedList<>();//老马的写法
    private final int MAX_COUNT = 10;
    private int count;

    public int getCount() {
        return count;
    }

    public synchronized void put(T t){
        System.out.println(Thread.currentThread().getName() +
                " start..");
        while (MAX_COUNT == list.size()){
//        while (MAX_COUNT == this.getCount()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ++count;
        list.add(t);
        this.notifyAll();
        System.out.println(Thread.currentThread().getName()+
                "add successfully and notifyAll ! now,count = "+this.getCount());
    }

    public synchronized T get(){
        System.out.println(Thread.currentThread().getName() +
                " start...");
        while(0 == list.size()){
//        while(0 == this.count){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        --count;
        this.notifyAll();
        System.out.println(Thread.currentThread().getName()+
                "get successfully and notifyAll ! now,count = "+this.getCount());
        return list.removeFirst();
    }

    public static void main(String[] args) {
        MyContainer01<String> container = new MyContainer01<>();
        //开启生产者线程
        for (int i = 1; i < 3; i++) {
            new Thread(() -> {
                container.put(new String("bean"));
            },"product_"+i).start();
        }
        //开启消费者线程
        for (int i = 1; i < 11; i++) {
            new Thread(() -> {
                container.get();
            },"custom_"+i).start();
        }
    }
}
