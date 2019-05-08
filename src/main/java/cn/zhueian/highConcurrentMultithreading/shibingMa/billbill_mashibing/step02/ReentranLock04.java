package cn.zhueian.highConcurrentMultithreading.shibingMa.billbill_mashibing.step02;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: qiucy
 * @Date: 2019-04-24 02:23
 * @Description:
 *  1.可以调用lockInterruptibly(),可对线程的interrupt()作出相应，会抛异常
 *  2.在一个线程等待锁的过程中，可以被打断 ---》 等同于lock.notifyAll的但是没有的到锁的线程interrupt
 */
public class ReentranLock04 {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        new Thread(() -> {
            System.out.println("t1 start..");
            lock.lock();
            try {
                System.out.println("t1 locked..");
                TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        },"t1").start();

        //TODO 还是抛异常我操
        Thread t2 = new Thread(() -> {
            System.out.println("t2 start..");
//            lock.lock();
            try {
                lock.lockInterruptibly();
                System.out.println("t2 locked..");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("t2 end");
            }catch (Exception e){
                System.out.println("t2 was interrupted..and throws Exception");
                e.printStackTrace();
            }finally {
                if(lock.isLocked()) lock.unlock();
            }
        },"t2");
        t2.start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //lockInterrupt()主线程去打断t2线程，tryLock()是自己打断自己的阻塞
        t2.interrupt();
    }
}
