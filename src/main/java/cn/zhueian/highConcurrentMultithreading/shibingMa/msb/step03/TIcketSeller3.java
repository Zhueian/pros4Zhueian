package cn.zhueian.highConcurrentMultithreading.shibingMa.msb.step03;

import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: qiucy
 * @Date: 2019-04-25 10:11
 * @Description:容器Vetory
 *  vetory所有方法都是加锁同步的
 *  但是vetory.size() && vetory.remove()不同步,脚标越界，但是不会重卖了
 */
public class TIcketSeller3 {
    static Vector<String> v = new Vector<>();
    static {
        for (int i = 1; i < 10001; i++) v.add("tickNO_"+i);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (v.size() > 0){
                    //测一万遍都可能不会出现问题，所有得放大这个非原子操作
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "::"+v.remove(0));
                }
            },"t"+i).start();
        }
    }
}
