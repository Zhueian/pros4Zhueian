package cn.zhueian.highConcurrentMultithreading.shibingMa.billbill_mashibing.step01.taobao_interview;


import org.springframework.ui.context.Theme;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: qiucy
 * @Date: 2019-04-23 14:59
 * @Description:淘宝一道面试题目：
 *  实现一个容器，提供add(T t),size()
 *  写两个线程，线程1添加10个元素，线程2实现监控元素个数，当个数到5个时，线程2给出提示并结束；
 */
public class MyContainer1 {

    //volatile有传递性，，，线程间透明
    volatile List list = new ArrayList();

    public void add(Object o){
        list.add(o);
    }

    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
        MyContainer1 container = new MyContainer1();
        //线程1
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+" start");

            for (int i = 0; i < 10; i++) {
                container.add(new Object());
                System.out.println("线程t1，add第 "+ (i+1) + "个元素");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();
        //线程2
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+" start");
            while (true){
                if(container.size() == 5){
                    System.out.println("add5个元素了，线程 t2 over");
                    break;
                }
            }
        },"t2").start();
    }
}
