package cn.zhueian.highConcurrentMultithreading.shibingMa.billbill_mashibing.step01.taobao_interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: qiucy
 * @Date: 2019-04-23 15:22
 * @Description:与MyContainer1相比：
 *  1。sleep在调试可以用生产一般不用，所以会有实际size大于5，线程2才break，两线程不同步嘛,不是很精确严谨；
 *  2。while（true）浪费cpu
 *
 *  注意：wait会释放锁；sleep不会释放锁，notify也不会是放锁;
 *      syn的lock只能比的线程notify，lock可以自己线程notify自己
 */
public class MyContianer2 {
    /*volatile*/ List list = new ArrayList();
    public void add(Object o){  list.add(o);}
    public int size(){  return list.size();}

    public static void main(String[] args) {
        MyContianer2 container = new MyContianer2();
        //final 确保，Lock变量上不会引用改变，new Xxx().lock -> 新的引用。
        final Object lock = new Object();
        //线程一
        new Thread(() -> {
            synchronized (lock){
                String name = Thread.currentThread().getName();
                System.out.println(name +" start");
                for (int i = 1; i < 11; i++) {
                    container.add(new Object());
                    System.out.println("t1 add nums = "+i);
                    if(i == 5){
                        lock.notifyAll();
                        try {
//                            Thread.currentThread().wait();
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println(name + " end");
            }
        },"t1").start();
        //监控线程二
        new Thread(() -> {
            synchronized (lock){
                String name2 = Thread.currentThread().getName();
                System.out.println(name2 + " start");
                System.out.println("t2 size = "+ container.size());
                if(container.size() != 5){
                    try {
//                        Thread.currentThread().wait();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    System.out.println("t2 size = 5,t2,over");
//                    Thread.currentThread().notifyAll();
                    lock.notifyAll();
                }
                System.out.println(name2 + " end");
            }

        },"t2").start();
    }
}
