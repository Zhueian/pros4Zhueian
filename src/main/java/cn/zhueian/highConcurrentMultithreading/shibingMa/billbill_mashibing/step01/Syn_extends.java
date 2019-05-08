package cn.zhueian.highConcurrentMultithreading.shibingMa.billbill_mashibing.step01;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: qiucy
 * @Date: 2019-04-22 18:17
 * @Description:继承中可能发生的情形，子类调用父类的同步方法
 *  也是重入锁概念：可以,锁对象就子类；
 *  但是子类初始化会先初始化一层一层的父类，子类对象包含父类对象！
 *
 */
public class Syn_extends {
    synchronized void m(){
        System.out.println("m start");
        try {
            TimeUnit.SECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        new Syn_extendsSub().m();
    }
}
class Syn_extendsSub extends Syn_extends{
    @Override
    synchronized void m(){
        System.out.println("sub start");
        super.m();
        System.out.println("sub end");
    }
}