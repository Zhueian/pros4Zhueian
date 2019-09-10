package cn.zhueian.highConcurrentMultithreading.shibingMa.msb.step02.interview_productAndCutsom;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: qiucy
 * @Date: 2019-04-24 10:36
 * @Description:老马对应MyContainer01源码
 *  TODO 有bug：不能队列无限执行。。。还有必须延时的问题
 */
public class MyContainer02<T> {
    private final LinkedList<T> list = new LinkedList<>();
    private final int MAX_VAL = 10;
    private int count;

    public int getCount() {
        return count;
    }

    public synchronized void put(T t){
        System.out.println(Thread.currentThread().getName()+
                " put start..");
        while(MAX_VAL == list.size()){
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
                " put end..");
    }

    public synchronized T get(){
        System.out.println(Thread.currentThread().getName()+
                " get start..");
        T t = null;
        while (0 == list.size()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        --count;
        t = list.removeFirst();
        System.out.println(Thread.currentThread().getName()+
                " get end..");
        return t;
    }

    public static void main(String[] args) {
        MyContainer02<String> container = new MyContainer02<>();

        for (int i = 1; i < 11; i++) {
            /*new Thread(() -> {
                System.out.println(container.get()+" xxoo");
            }).start();*/
            new Thread(() -> {
                for (int j = 0; j < 5; j++) System.out.println("get " +container.get());
            },"custom_"+i).start();
        }

        //不加延时可能会出问题，加了延时，延时越长越不出问题

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 1; i < 3; i++) {
            /*new Thread(() -> {
                while (true) container.put("bean");
            },"product_"+i).start();*/
            new Thread(() -> {
                for (int j = 0; j < 25; j++) container.put("bean_"+j);
            },"product_"+i).start();
        }

    }
}
