package cn.zhueian.highConcurrentMultithreading.shibingMa.billbill_mashibing.step03;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @Auther: qiucy
 * @Date: 2019-04-24 12:35
 * @Description:100张火车票，是个线程线程去买;
 * 队列fifo，filo，双端队列Deque。
 */
public class TIckSeller04_src {

    static Queue<String> tickets = new ConcurrentLinkedDeque<>();
    //这么写首先得注意中间不能add(null)，否则会thread.kill()，queue，deque不能装null值
    static {
        for (int i = 0; i < 100; i++) tickets.add("tick_"+(i+1));
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
               while (true){
                   String tick = tickets.poll();
                   //下边两行代码，只有判断，而不像前面得demo有remove()，修改操作。
                   if(tick == null) break;
                   else System.out.println(Thread.currentThread().getName()+" sell the "+tick);
               }
            },"window_"+i).start();
        }
    }
}
