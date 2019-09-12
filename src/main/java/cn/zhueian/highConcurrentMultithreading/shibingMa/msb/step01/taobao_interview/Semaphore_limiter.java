package cn.zhueian.highConcurrentMultithreading.shibingMa.msb.step01.taobao_interview;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

/**
 * Created by qiucy on 2019/9/12.
 * java.Semaphore：允许多个线程访问临界区，读写os态的sema
 * 简而言之：一个计数器，一个等待队列，三个方法init()、down() 和 up()，跟Latch原理一样，不说了
 */
public class Semaphore_limiter {
    public static void main(String[] args) {
        SthPool<Integer, String> p = new SthPool<Integer, String>(10,2);
        p.exec(t->{
            System.out.println(t);
            return t.toString();
        });
    }
}
class SthPool<T,R>{
    List<T> pool;
    Semaphore sema;
    SthPool(int l,T t){
        pool = new Vector<T>();
        for (int i = 0;i<l;++i) pool.add(t);
        sema = new Semaphore(l);
    }
    //用池子对象调用func
    R exec(Function<T,R> f){
        T t = null;
        try {
            //致敬吧：荷兰人Dijkstra的贡献
            //down(),也是os的荷兰语方法P(),有上锁意思
            //，执行队列前10线程，后面等着阻塞
            sema.acquire();
            t = pool.remove(0);
            return f.apply(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //执行完释放，唤醒后面线程竞争进来吧
            pool.add(t);
            //up(),也是os的荷兰语方法V(),又解锁意思
            //更新计数器
            sema.release();
        }
        return null;
    }
}
