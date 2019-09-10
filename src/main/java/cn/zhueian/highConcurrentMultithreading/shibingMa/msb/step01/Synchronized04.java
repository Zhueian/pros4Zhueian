package cn.zhueian.highConcurrentMultithreading.shibingMa.msb.step01;

/**
 * @Auther: qiucy
 * @Date: 2019-04-21 20:22
 * @Description:
 */
public class Synchronized04 {
    private static int count = 10;
    //锁为当前Synchronized.class,Class的一个实例，
    // static method不需要new synchronized()实例
    public static synchronized void m(){
        count --;
        System.out.println(Thread.currentThread().getName()
                + "count = " + count);
    }

}
