package cn.zhueian.highConcurrentMultithreading.shibingMa.billbill_mashibing.step03;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: qiucy
 * @Date: 2019-04-25 10:24
 * @Description:加锁效率太低了。
 */
public class TIcketSeller4 {
    static List<String> list = new ArrayList<>();
    static {
        for (int i = 1; i < 1001; i++) list.add("ticketNO_"+i);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true){
                    synchronized (list){
                        if(list.size() <= 0) break;
                        try {
                            TimeUnit.MILLISECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "::" + list.remove(0));
                    }
                }
            },"t_"+i).start();
        }
    }
}
