package cn.zhueian.highConcurrentMultithreading.shibingMa.msb.step01;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Auther: qiucy
 * @Date: 2019-04-22 18:45
 * @Description:volatitle使一个变量在多个线程间透明（通知cpu线程缓存区的独立copy变量刷新，
 * 注意要不同的cpu维护的线程才会不透明，写操作会刷新主内存，读操作可能不会刷新为主内存的母体）
 *
 * volatitle比syn轻很多，也是种无锁同步。'
 * syn既有可见性也有原子性；
 * volatitle不能保证多线程修改统一资源的一致性问题
 *
 */
public class VolatitleDemo {
    //static 也不能解决线程间的透明问题
    //没有volatile可用Atomic代替
    AtomicBoolean running = new AtomicBoolean(true);
//    static /*volatile*/ boolean running = true;
    void m(){
        System.out.println("m start");
        while (running.get()){
//        while (running){
            //也能不用volatitle，但是不保证以后一定不会出问题
            //所以该用volatitle时候还得用volatitle
            /*try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
        System.out.println("m end");

    }

    public static void main(String[] args) {
        VolatitleDemo t = new VolatitleDemo();
        new Thread(() -> t.m(),"t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        t.running = false;
        t.running.getAndSet(false);
//        VolatitleDemo.running = false;
    }
}
