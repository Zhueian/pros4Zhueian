package cn.zhueian.highConcurrentMultithreading.shibingMa.msb.step01;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: qiucy
 * @Date: 2019-04-22 19:01
 * @Description:异常会释放锁，会影响到异常后来线程的取值，所以要事务回滚 或者 trycatch不释放锁
 * eg：比方说servlet同时处理多线程，一个
 */
public class Syn_Exceptions {
    int count = 0;
    synchronized void m(){
        System.out.println(Thread.currentThread().getName()+" start");
        while (true){
            count++;
            System.out.println(Thread.currentThread().getName()+
                    " count = " + count);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(count == 5){
                int i = 10/0;
            }
        }
    }

    public static void main(String[] args) {
        Syn_Exceptions t = new Syn_Exceptions();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                t.m();
            }
        };
        new Thread(r,"t1").start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(r,"t2").start();
    }
}
