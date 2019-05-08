package cn.zhueian.highConcurrentMultithreading.shibingMa.billbill_mashibing.step01;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: qiucy
 * @Date: 2019-04-22 17:34
 * @Description:一个方法可以调用另一个同步方法；
 *  一个线程已经拥有某个对象的锁，再次申请仍然能得到锁
 *  加锁：Field++，jdk自动解锁：Field--；
 */
public class Syn09_keChongRu {
    public synchronized void m1(){
        System.out.println("m1,start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m2();
    }

    private synchronized void m2() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2,end");

    }
}
