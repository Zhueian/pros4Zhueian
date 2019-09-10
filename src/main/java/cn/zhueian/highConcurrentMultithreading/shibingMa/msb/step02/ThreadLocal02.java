package cn.zhueian.highConcurrentMultithreading.shibingMa.msb.step02;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: qiucy
 * @Date: 2019-04-25 09:10
 * @Description:
 *  ThreadLocal:线程局部变量，空间换时间；
 *  synchronized是以时间换空间；
 *  hibernate中的session用存在Threadlocal中，SessionFactory产生的Session
 *  spring也好mybatis也好大量使用了Threadlocal
 */
public class ThreadLocal02 {
    ThreadLocal<Person> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        ThreadLocal02 t = new ThreadLocal02();
        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(t.threadLocal.get());
        },"t1");

        Thread t2 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t.threadLocal.set(new Person());
        },"t2");
        t1.start();
        t2.start();
        //处理threadlcoal的内存泄漏
        try {
            System.out.println("try before");
            t1.join();
            t2.join();
            System.out.println("try after");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            t.threadLocal.remove();
        }
    }
    private static class Person{
        String name = "zhangshan";
    }
}
