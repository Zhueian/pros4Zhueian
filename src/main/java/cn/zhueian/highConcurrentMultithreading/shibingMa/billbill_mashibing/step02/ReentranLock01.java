package cn.zhueian.highConcurrentMultithreading.shibingMa.billbill_mashibing.step02;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: qiucy
 * @Date: 2019-04-24 01:50
 * @Description:ReentranLock用来替代Synchronized
 *  默认也是this作为锁
 */
public class ReentranLock01 {
    synchronized void m1(){
        for (int i = 0; i < 10; i++) {
            System.out.println("m1 "+i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    synchronized void m2(){
        System.out.println("m2 ... ");
    }

    public static void main(String[] args) {
        ReentranLock01 t = new ReentranLock01();
        new Thread(t::m1,"t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(t::m2,"t2").start();
    }
}
