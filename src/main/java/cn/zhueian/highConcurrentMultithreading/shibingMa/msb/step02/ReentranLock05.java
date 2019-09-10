package cn.zhueian.highConcurrentMultithreading.shibingMa.msb.step02;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: qiucy
 * @Date: 2019-04-24 02:51
 * @Description:
 *  可以指定为公平锁: Lock lock = new ReentrantLock(true);
 *   公平锁：非竞争，但是消耗线程调度器资源效率低，但是稍微等待锁跟时间有序
 *          但是很不稳定！！！
 */
public class ReentranLock05 extends Thread{
    //比较true和false
    //TODO 妈的老马的源码有bug
    private static ReentrantLock lock = new ReentrantLock(true);
//    final static Lock lock = new ReentrantLock(true);

    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            lock.lock();
            try{
                System.out.println(Thread.currentThread().getName() +
                        " getLcok ,time = " + i);
                //TODO 这么写就公平了我操，还是我的maccpu太刁？？
                TimeUnit.MILLISECONDS.sleep(1);
                System.out.println();
            }
            catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentranLock05 r = new ReentranLock05();
        Thread t1 = new Thread(r, "t1");
        Thread t2 = new Thread(r, "t2");
        t1.start();
        t2.start();
    }
}
