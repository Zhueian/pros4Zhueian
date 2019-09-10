package cn.zhueian.highConcurrentMultithreading.shibingMa.msb.step03.concurrent_container;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * @Auther: qiucy
 * @Date: 2019-04-27 18:52
 * @Description:
 *  跟SynchronusQueue一样
 *  转换队列->其transfer()方法就是：
 *      往往消费者先启动，生产者看看有没有空闲的消费者，有就直接给消费者，而不会进入队列，效率高。
 *      没有空闲消费者就会阻塞
 *  比如坦克大战坦克动作，有一堆空闲的消费者
 *  实时数据用这个，netty
 *  transfer(),提供了一种更精确的队列和线程的控制
 */
public class T07_TransferQueue {
    public static void main(String[] args) {
        //注释块1：没任何打印，阻塞在transger("aaaa")；
        //注释块3：打印aaaa 程序结束
        //不注释：打印aaaa 阻塞在第二个queue.take();
        TransferQueue<String> queue = new LinkedTransferQueue<>();
        //先启动消费者
//        new Thread(() -> {
//            try {
//                System.out.println(queue.take());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();

        try {
            queue.transfer("aaaa");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //后启动消费者
        new Thread(() -> {
            try {
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
