package cn.zhueian.highConcurrentMultithreading.shibingMa.msb.step01;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: qiucy
 * @Date: 2019-04-22 20:23
 * @Description:粗粒度的锁比细粒度的锁效率低不少
 */
public class Syn_lidu {
    private int count = 0;
    synchronized void m1(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count ++;
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void m2(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this){
            count++;
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }
}
