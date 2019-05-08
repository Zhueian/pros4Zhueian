package cn.zhueian.highConcurrentMultithreading.shibingMa.billbill_mashibing.step04;

import java.util.concurrent.*;

/**
 * @Auther: qiucy
 * @Date: 2019-04-24 12:55
 * @Description:
 */
public class T06_Future_src {
    public static void main(String[] args) throws Exception {
//        FutureTask<Integer> task = new FutureTask<Integer>(() -> {
//            TimeUnit.MILLISECONDS.sleep(500);
//            return 1;
//        });
//        new Thread(task).start();
//        System.out.println(task.get());
        //=======
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 6; i++) {
            Future<Integer> f = service.submit(() -> {
                TimeUnit.MILLISECONDS.sleep(500);
                return 1;
            });
            System.out.println(f.get());
        }
    }
}
