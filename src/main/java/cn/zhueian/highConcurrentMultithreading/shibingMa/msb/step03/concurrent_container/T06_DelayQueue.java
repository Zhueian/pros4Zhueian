package cn.zhueian.highConcurrentMultithreading.shibingMa.msb.step03.concurrent_container;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: qiucy
 * @Date: 2019-04-26 14:09
 * @Description:
 *  无界阻塞队列，
 *  但是每个元素可以看成一个任务，每一个元素都得消费者等一会才能拿，
 *  每个元素都会自己维护自己的countDown。。。。
 *  等了最长的元素先往外拿的顺序，按等待了的时间排序
 *  即是，过了自定义的延时时间后还在等待了的时间！！
 *  可以用来做定时执行的任务。
 *  需要put(),add(),offer() 的元素要Impl Delayed-> getDelay();compareTo();
 *  TODO 这个容器没整明白。
 */
public class T06_DelayQueue {
    private static class MyTask implements Delayed{
        private long runningTIme;

        public MyTask(long runningTIme) {
            this.runningTIme = runningTIme;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(runningTIme - System.currentTimeMillis(),TimeUnit.MILLISECONDS);
        }
        @Override
        public int compareTo(Delayed o) {
            if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS)) return -1;
            else if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)) return 1;
            else return 0;
        }

        @Override
        public String toString() {
            return ""+runningTIme;
        }
    }
    static BlockingQueue<MyTask> queue = new DelayQueue<>();

    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        try {
            //第一个任务1s后执行
            queue.put(new MyTask(now+1000));
            //第一个任务2s后执行
            queue.put(new MyTask(now + 2000));
            //第一个任务1。5s后执行
            queue.put(new MyTask(now+1500));
            //第一个任务0。5s后执行
            queue.put(new MyTask(now+500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(queue);
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
