package cn.zhueian.highConcurrentMultithreading.shibingMa.billbill_mashibing.step04;


import java.util.concurrent.*;

/**
 * @Auther: qiucy
 * @Date: 2019-04-28 14:23
 * @Description:
 * TODO FutureTask && Future区别：Future<V> f = </>service.submit(Callable<V> c)的submit会new FutureTask
 * 数据库连接池简单的说就是一个线程池，每个线程维护相对一个的数据库连接（session keepLive）；
 * 线程池是一个更加普通的概念；
 * 线程池里面的维护可以是各种业务类型：DB连接池，网络连接池，工人消息处理池，消息的生产者的池，发邮件的池；
 *
 */
public class T06_Future {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new Thread(new FutureTask<Integer>(() -> {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread().getName()+"_demo01");
            return 1000;
        })).start();

        System.out.println("==============================================");
        //Exception:Future is abstract method can not be instanced!
//        new Thread(new Future<Integer>(new Callable<Integer>() {
//            @Override
//            public Integer call() throws Exception {
//                return 1000;
//            }
//        })).start();

        System.out.println("==============================================");

        FutureTask<Integer> f = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName()+"_demo02");
                return 1000;
            }
        });
        new Thread(f).start();
        //阻塞方法！
        System.out.println(f.get());

        System.out.println("==============================================");

        Future<Integer> fu = Executors.newSingleThreadExecutor().submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"_demo03");
            return 1000;
        });
        //阻塞
        System.out.println(fu.isDone());
        //阻塞
        System.out.println(fu.get());
    }
}
