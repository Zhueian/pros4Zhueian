package cn.zhueian.highConcurrentMultithreading.shibingMa.msb.step01;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: qiucy
 * @Date: 2019-04-22 19:52
 * @Description:只是涉及到见到的算数运算，要保证线程间原子性和透明性：AtomicXXX
 *  用cas实现，比syn高效。
 *  多行Atomic是没有原子性的
 */
public class AtomicXXX01 {
    AtomicInteger count = new AtomicInteger(0);
    void m(){
        for (int i = 0; i < 10000; i++) count.incrementAndGet();
    }

    public static void main(String[] args) {
        AtomicXXX01 t = new AtomicXXX01();
        ArrayList<Thread> threads = new ArrayList<>();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                t.m();
            }
        };
        for(int i = 0;i < 10;i++) threads.add(new Thread(r," thread-"+i));

        threads.forEach((o) -> o.start());
        threads.forEach((o)-> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //效果join一样
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(t.count+"!");

    }
}
