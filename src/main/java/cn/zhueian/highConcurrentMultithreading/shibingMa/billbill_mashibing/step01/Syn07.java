package cn.zhueian.highConcurrentMultithreading.shibingMa.billbill_mashibing.step01;

import org.springframework.ui.context.Theme;

/**
 * @Auther: qiucy
 * @Date: 2019-04-22 14:56
 * @Description:同步方法和非同步方法是否可以同时调用?
 *  可以，哪怕在syn方法里调用非syn方法，方法内的变量属于线程私有栈变量，独立的
 */
public class Syn07 {
    /**
     *     执行 m1 要锁定当前对象
     */
    public synchronized void m1(){
        System.out.println(Thread.currentThread().getName() +
                " m1 start..");
        m2();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +
                " m1 end..");


    }

    /**
     *     执行 m2 不需要锁定当前对象
     */
    public void m2(){
        System.out.println(Thread.currentThread().getName()+" m2,start!");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" m2 end!");
    }

    public void m3(int a){
        System.out.println(Thread.currentThread().getName()+" m2,start!");
        System.out.println(a);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" m2 end!");
    }

    public static void main(String[] args) {
        Syn07 t = new Syn07();
//        new Thread(() -> t.m1(),"t1").start();
//        new Thread(() -> t.m2(),"t2").start();

        new Thread(t::m1,"t1").start();
        new Thread(t::m2,"t2").start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                t.m1();
//            }
//        });
    }
}
