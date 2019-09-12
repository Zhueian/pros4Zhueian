package cn.zhueian.highConcurrentMultithreading.shibingMa.msb.step01.taobao_interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Auther: qiucy
 * @Date: 2019-04-23 16:21
 * @Description:最简单的方式：Countdownlatch门闩；信号量
 *  latch.await()；不需要锁定任何对象，比lock.wait()灵活。
 *  CountDownLatch/Semaphore/Cyclibarrier
 *
 */
public class MyContainer3_CountdownLatch {
    volatile List l = new ArrayList();
//    /*volatile*/ List l = new ArrayList();
    public void add(Object o){  l.add(o);}
    public int size(){  return l.size();}

    public static void main(String[] args) {
        MyContainer3_CountdownLatch container = new MyContainer3_CountdownLatch();
        CountDownLatch latch = new CountDownLatch(1);
        CountDownLatch latch2 = new CountDownLatch(1);

        //TODO t2代码块和t1代码块相互位置会有不同效果，，，非得加TimeUtil.SECONED.sleep(int time)??src这个程序不完美啊

        //add线程 t1
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " start");
            for (int i = 1; i < 11; i++) {
                container.add(new Object());
                System.out.println("t1 add nums = "+i);
                if(i == 5){
                    latch.countDown();
                    try {
                        latch2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(Thread.currentThread().getName() + " end");
        },"t1").start();

        //size监控线程 t2
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " start");
            System.out.println("list size = " + container.size());
            if(container.size() != 5){
                try {
                    latch.await();
                    System.out.println("t2 waitout");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                latch2.countDown();
            }
            System.out.println(Thread.currentThread().getName() + " end");
        },"t2").start();
    }
}
