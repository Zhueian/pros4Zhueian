package cn.zhueian.highConcurrentMultithreading.shibingMa.billbill_mashibing.step01;

/**
 * @Auther: qiucy
 * @Date: 2019-04-21 20:13
 * @Description:
 */
public class Synchronized02 {
    private int count = 10;
    public void m(){
        synchronized (this){
            count --;
            System.out.println(Thread.currentThread().getName()
            +"count: " + count);
        }
    }
}