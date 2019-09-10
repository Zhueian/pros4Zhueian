package cn.zhueian.highConcurrentMultithreading.shibingMa.msb.step01;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: qiucy
 * @Date: 2019-04-22 17:54
 * @Description:死锁01
 */
public class Syn_DeadLock01 {
    static Object o1 = new Object(),o2 = new Object(),o3 = new Object();
    private int flag = 0;
    private void m(){
        if(flag == 0){
            synchronized (o1){
                System.out.println("flag == 0,out,waiting...");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2){
                    System.out.println("flag == 0,waiting...");
                }
            }
        }
        if(flag == 1){
            synchronized (o2){
                System.out.println("flag == 1,out,waiting...");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o3){
                    System.out.println("flag == 1,in,waiting...");
                }
            }
        }
        if(flag == 2){
            synchronized (o3){
                System.out.println("flag == 2,out,waiting...");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1){
                    System.out.println("flag == 2,in,waiting...");
                }
            }
        }
    }

    public static void main(String[] args) {
//        Syn_DeadLock01 t1 = new Syn_DeadLock01();
//        Syn_DeadLock01 t2 = new Syn_DeadLock01();
//        Syn_DeadLock01 t3 = new Syn_DeadLock01();
//        t1.flag = 0;
//        t2.flag = 1;
//        t3.flag = 2;
//        new Thread(t1::m).start();
//        new Thread(t2::m).start();
//        new Thread(t3::m).start();

        for (int i = 0; i < 3; i++) {
            Syn_DeadLock01 t = new Syn_DeadLock01();
            t.flag = i;
            new Thread(t::m).start();
        }
    }
}
