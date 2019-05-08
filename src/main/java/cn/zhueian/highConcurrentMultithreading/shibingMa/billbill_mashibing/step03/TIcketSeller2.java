package cn.zhueian.highConcurrentMultithreading.shibingMa.billbill_mashibing.step03;

import java.util.ArrayList;

/**
 * @Auther: qiucy
 * @Date: 2019-04-25 09:58
 * @Description:重卖，超卖，卖null，
 * remove()不是原子性，重卖
 * list.size() && list.remove(0)更不是原子性，数组下标越界。
 */
public class TIcketSeller2 {
    static ArrayList<String> list = new ArrayList<>();
    static{
        for (int i = 1; i < 10001; i++) list.add("ticket_NO_"+i);
    }
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (list.size() > 0){
                    System.out.println(Thread.currentThread().getName() + "::" + list.remove(0));
                }
            },"t_"+i).start();
        }
    }
}
