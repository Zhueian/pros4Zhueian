package cn.zhueian.geektime.juc01;

/**
 * Created by qiucy on 2019/9/2.
 * 01可见性、原子性和有序性
 * 循环 10000 次 count+=1 操作如果改为循环 1 亿次，你会发现效果更明显，最终 count 的值接近 10000 次，
 * count 的值接近 20000，原因是两个线程不是同时启动的，有一个时差。
 */
public class T01 {
    private long count = 0;
    private void add10k(){
        int idx = 0;
        while (idx++<10000) count++;
    }
    static long calc(){
        T01 test1 = new T01();
        //create俩线程
        Thread t1 = new Thread(() -> {
            test1.add10k();
        },"t1");
        Thread t2 = new Thread(() -> {
            test1.add10k();
        },"t2");
        t1.start();t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return test1.count;
    }

    public static void main(String[] args) {
        System.out.println("count:"+calc());
    }
}
