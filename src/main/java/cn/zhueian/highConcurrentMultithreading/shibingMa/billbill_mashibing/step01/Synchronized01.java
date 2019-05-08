package cn.zhueian.highConcurrentMultithreading.shibingMa.billbill_mashibing.step01;

/**
 * @Auther: qiucy
 * @Date: 2019-04-21 20:06
 * @Description:synchronized关键字,对某个对象加锁，互斥重入锁
 */
public class Synchronized01 {
    private int count = 10;
    /**
     * 去申请锁是记录在堆的 object里面，重入锁会field -> i++
     */
    private Object o = new Object();

    public void m(){
        //要想执行一下代码要渠道锁：o
        synchronized (o){
            count -- ;
            System.out.println(count);
        }
    }

}
