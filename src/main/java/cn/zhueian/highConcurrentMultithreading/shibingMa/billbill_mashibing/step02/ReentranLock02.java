package cn.zhueian.highConcurrentMultithreading.shibingMa.billbill_mashibing.step02;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: qiucy
 * @Date: 2019-04-24 01:54
 * @Description:Reentranlock是
 * 手动上锁的；
 * 必须手动解锁；
 * 不想synchronized那样jdk帮你解决了一堆篓子
 * 抛异常也不会解锁；
 */
public class ReentranLock02 {
    //ReentranLock定义在外面，最好家和final
    /*final*/ Lock lock = new ReentrantLock();
    void m1(){
        //等同于synchronized(this)
        //lock.lock()..写在try外面
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("m1 .. "+i);
                TimeUnit.SECONDS.sleep(1);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    void m2(){
        lock.lock();
        System.out.println("m2..");
        lock.unlock();
    }

    public static void main(String[] args) {
        ReentranLock02 t = new ReentranLock02();
        new Thread(t::m1,"t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(t::m2,"t2").start();
    }
}
