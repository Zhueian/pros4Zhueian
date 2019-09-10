package cn.zhueian.highConcurrentMultithreading.shibingMa.msb.step01;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: qiucy
 * @Date: 2019-04-22 15:18
 * @Description:对业务写方法加锁，读方法不加锁，容易产生脏读dirtyRead
 */
public class Syn08_Account {
    String name;
    double balance;

    public static void main(String[] args) {
        double a = 0.03;
        double b = 0.02;
        System.out.println((double)(a-b));

        Syn08_Account t = new Syn08_Account();
        new Thread(() -> t.set("zhangsan",100.0)).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(t.getBalance("zhangsan"));


        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(t.getBalance("zhangsan"));
    }
    public synchronized void set(String name,double balance){
        this.name = name;
        //放大多线程时差切换问题，读到为提交的数据。
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
    }

    //syn解决脏读，效率极其低
    public /*synchronized*/ double getBalance(String name){
        return this.balance;
    }
}
