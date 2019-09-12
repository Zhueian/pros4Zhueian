package cn.zhueian.highConcurrentMultithreading.shibingMa.msb.step03.concurrent_container;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Auther: qiucy
 * @Date: 2019-04-26 12:49
 * @Description:在并发容器中queue dueue是最重要，应用最多的，
 * 还是避开syn那套：cas+volatile

 * TODO 异步方案：用队列解耦？
 */
public class T03_ConcurrentQueue {
    public static void main(String[] args) {
        Queue<String> queue = new ConcurrentLinkedQueue();
        for (int i = 0; i < 10; i++) {
            //add()一样，要是ConcurrentArrayQeeue；有界队列会抛异常bool b = offer()不会
            boolean offer = queue.offer("a" + i);
        }

        System.out.println(queue);
        System.out.println(queue.size());
        System.out.println("==================");
        //poll():从队首拿一个元素,并且删掉（ remove() ）；
        System.out.println(queue.poll());
        System.out.println(queue.size());
        //peek():从队首拿一个元素,并且不删掉
        System.out.println("==================");
        System.out.println(queue.peek());
        System.out.println(queue.size());

        //双端队列,看api就懂了，特简单。
    }
}
