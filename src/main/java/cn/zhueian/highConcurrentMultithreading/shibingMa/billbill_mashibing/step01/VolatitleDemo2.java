package cn.zhueian.highConcurrentMultithreading.shibingMa.billbill_mashibing.step01;

import java.util.ArrayList;

/**
 * @Auther: qiucy
 * @Date: 2019-04-22 19:36
 * @Description:运行一下程序分析结果:永远小于10W
 *  光可见没用，还得一致性，++操作不是原子操作。
 */
public class VolatitleDemo2 {
    private volatile int count = 0;
    //synchronized解决这个不到10W的问题
    synchronized void m(){
        // count++ 操作不是原子操作。
        for (int i = 0; i < 10000; i++) count++;
    }

    public static void main(String[] args) {
        VolatitleDemo2 tt = new VolatitleDemo2();
        ArrayList<Thread> threads = new ArrayList<>();
        for(int i = 0; i < 10;i++) threads.add(new Thread(tt::m," thread-"+i));
        threads.forEach((t) -> t.start());
        //join保证了主线程太快，不会马上打印别的线程还没算完的count值
        // TODO 但是这样不就会肯定有10W吗？
        threads.forEach((t) -> {
            try{
                //合并线程
                t.join();
            }catch (Exception e){
                e.printStackTrace();
            }
        });

        System.out.println(tt.count);
    }
}
