package cn.zhueian.highConcurrentMultithreading.shibingMa.msb.step02;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: qiucy
 * @Date: 2019-04-24 02:02
 * @Description:  bool locked = ReentranLock.tryLock(int num,TimeUnit);
 *                if(Locked) lock.unlock();//没拿着锁unlock会Throws Exception
 *  有点乐观锁的味道了；
 *  与synchronized比没啥性能区别
 */
public class ReentranLock03 {
    final Lock lock = new ReentrantLock();
    void m1(){
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("m1..."+i);
                TimeUnit.SECONDS.sleep(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    void m2(){
        boolean locked = false;
        try {
            //阻塞方法，最长尝试五秒尝试去锁
            locked = this.lock.tryLock(5,TimeUnit.SECONDS);
            System.out.println("m2 tryLock = "+locked);
            if(locked){
                System.out.println("m2 -> locked ..");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(locked) lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentranLock03 t = new ReentranLock03();
        new Thread(t::m1,"t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(t::m2,"t2").start();
    }
}
