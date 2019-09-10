package cn.zhueian.highConcurrentMultithreading.shibingMa.msb.step03;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Auther: qiucy
 * @Date: 2019-04-25 09:42
 * @Description:
 *  有n张火车票，没张票都有个编号；
 *  同时有十个窗口对外销售；
 *
 *  联想拼团的分布式锁和秒杀的超卖和重复火车票编号的销售
 */
public class TicketSeller1 {
    static ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
//    static SynchronousQueue<String> queue = new SynchronousQueue<>();
    static{
//        TicketSeller1 ticketSeller1 = new TicketSeller1();
        for (int i = 1; i < 101; i++) {
            queue.add("ticketNO_"+i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
//            TicketSeller1 ticketSeller1 = new TicketSeller1();
            new Thread(() -> {
                while (true){
                    String ticket = queue.poll();
                    if(ticket == null) break;
                    else System.out.println(Thread.currentThread().getName() +"::"+ ticket);
                }
            },"t_"+i).start();
        }
    }
}
