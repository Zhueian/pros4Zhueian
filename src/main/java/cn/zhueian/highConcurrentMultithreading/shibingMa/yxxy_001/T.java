package cn.zhueian.highConcurrentMultithreading.shibingMa.yxxy_001;

/**
 * @Auther: qiucy
 * @Date: 2019-04-17 19:10
 * @Description:
 */
public class T {
    /**
     * synchronized关键字
     * 对某个对象加锁
     *
     */
    private int count = 10;
    private Object o = new Object();

    public void m(){
        synchronized (o){
            count --;
            System.out.println(Thread.currentThread().getName() + " count = " +count);
        }
    }
}
