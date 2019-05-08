package cn.zhueian.highConcurrentMultithreading.shibingMa.billbill_mashibing.step01;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: qiucy
 * @Date: 2019-04-23 14:34
 * @Description:锁定某个对象，如果锁o的属性发生改变，不影响锁的应用，
 * 但对象的引用的改变会，很好理解，，，锁的本质是堆内存实例而不是引用
 */
public class Syn17 {
    Object lock = new Object();

    void m(){
        synchronized (lock){
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        Syn17 t = new Syn17();
        //开启第一个线程
        new Thread(t::m,"t1").start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //开启第二个线程
        Thread t2 = new Thread(t::m, "t2");
        //锁对象引用发生改变了，所以t2线程得以执行，要是注释此行代码，t2线程永远无法执行
        //t.lock = new Object();
        t2.start();
    }
}
