package cn.zhueian.highConcurrentMultithreading.shibingMa.msb.step01;

/**
 * @Auther: qiucy
 * @Date: 2019-04-21 20:17
 * @Description:
 */
public class Synchronized03 {
    private int count = 10;
    //this为锁，是要执行m时候要锁定this的加锁对象，在此即是当前对象，而不是代码块和方法
    public synchronized void m(){
        count --;
        System.out.println(count);
    }
}
