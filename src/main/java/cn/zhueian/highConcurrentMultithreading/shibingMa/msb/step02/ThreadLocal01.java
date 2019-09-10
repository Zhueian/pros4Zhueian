package cn.zhueian.highConcurrentMultithreading.shibingMa.msb.step02;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: qiucy
 * @Date: 2019-04-25 09:04
 * @Description:Threadlocal,线程局部变量。
 */
public class ThreadLocal01 {
    //写不写voltile结果一致，不写voltile有可能发生问题，该写还是得写上volatile
    volatile Person p = new Person();

    public static void main(String[] args) {
        ThreadLocal01 t = new ThreadLocal01();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(t.p.name);
        },"t1").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t.p.name = "lisi";
        }).start();
    }
}
class Person{
    String name = "zhangshan";
}
