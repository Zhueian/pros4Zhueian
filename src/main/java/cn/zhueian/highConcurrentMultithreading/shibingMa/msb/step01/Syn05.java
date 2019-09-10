package cn.zhueian.highConcurrentMultithreading.shibingMa.msb.step01;

/**
 * @Auther: qiucy
 * @Date: 2019-04-22 14:37
 * @Description:分析程序输出
 */
public class Syn05 implements Runnable{
    private int count = 10;

    @Override
    public /*synchronized*/ void run() {
        //没有syn会有重复值，有syn会唯一输出
        count--;
        System.out.println(Thread.currentThread().getName() +
                " count = "+count);
    }

    public static void main(String[] args) {
        Syn05 t = new Syn05();
        for (int i = 1; i < 10; i++) {
            new Thread(t,"Thread" + i).start();
        }
    }
}
