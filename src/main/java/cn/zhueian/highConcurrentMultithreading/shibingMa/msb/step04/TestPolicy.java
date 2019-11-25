package cn.zhueian.highConcurrentMultithreading.shibingMa.msb.step04;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import javax.annotation.PostConstruct;
import java.util.concurrent.*;

/**
 * Created by qiucy on 2019/10/29.
 */
public class TestPolicy {
    private final static int TASKNUM = 8,THEADNUM = 1;

    private  volatile ExecutorService exec = null;

    private ScheduledExecutorService exec2 = Executors.newScheduledThreadPool(2);

    private String cacheKey;

    public static void main(String[] args) {
        ExecutorService exe = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
            exe.execute(()->{
                String l = "subAppFromDB2Cache2_jvm_fixTP_lock";
                System.out.println(l.hashCode());

            });
        }
    }
    static {

    }
    public TestPolicy(){
        new Thread(()->{
            try {
                while (true){
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }


    public @PostConstruct void init() throws InterruptedException {
        ThreadFactory tpFac = new ThreadFactoryBuilder().setNameFormat("Asyn4SubAppService-%d").build();
        exec =  new ThreadPoolExecutor
                (THEADNUM, THEADNUM+2, 0, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(TASKNUM), tpFac,
                        new Policy4Asyn4SubAppService());
    }

    /**
     * fixme 定义拒绝策略，但是不做也行似乎，最坏情况让用户等两小时再更新
     */
    private class Policy4Asyn4SubAppService implements RejectedExecutionHandler{
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println();
        }
    }
}
