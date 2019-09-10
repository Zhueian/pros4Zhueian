package cn.zhueian.highConcurrentMultithreading.shibingMa.msb.step04;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Auther: qiucy
 * @Date: 2019-04-27 20:49
 * @Description:
 *  ExecutorService extends Executor
 *  接口
 *  主要是两个重新两方法Future<T> result = service.submit(Runnable/Callable<T> o);
 *  service就是服务，一堆后台线程等着被人扔任务。
 *  execute(Runnable t)->void;
 *  submit(Callable<T>/Runnable)->Future<T>;
 */
public class T02_ExecutorService {
    public static void main(String[] args) {
        ExecutorService service = new ExecutorService() {
            @Override
            public void execute(Runnable command) {

            }
            @Override
            public void shutdown() {

            }
            @Override
            public List<Runnable> shutdownNow() {
                return null;
            }
            @Override
            public boolean isShutdown() {
                return false;
            }
            @Override
            public boolean isTerminated() {
                return false;
            }
            @Override
            public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
                return false;
            }
            @Override
            public <T> Future<T> submit(Callable<T> task) {
                return null;
            }
            @Override
            public <T> Future<T> submit(Runnable task, T result) {
                return null;
            }
            @Override
            public Future<?> submit(Runnable task) {
                return null;
            }
            @Override
            public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
                return null;
            }
            @Override
            public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
                return null;
            }
            @Override
            public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
                return null;
            }
            @Override
            public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
                return null;
            }
        };
    }
}
