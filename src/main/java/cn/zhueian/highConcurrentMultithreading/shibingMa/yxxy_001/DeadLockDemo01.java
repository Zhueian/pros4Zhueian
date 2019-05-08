package cn.zhueian.highConcurrentMultithreading.shibingMa.yxxy_001;


/**
 * @Auther: qiucy
 * @Date: 2019-04-19 18:25
 * @Description:
 */
public class DeadLockDemo01 implements Runnable {
    static Object o1 = new Object(), o2 = new Object();
    public int flag = 1;
    @Override
    public void run() {
        if(flag == 0){
            synchronized (o1){
                System.out.println("flag = 1,得到o1，第1层，");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2){
                    System.out.println("flag = 1,得到o2，第2层，");
                }
            }
        }
        if(flag == 1){
            synchronized (o2){
                System.out.println("flag = 2,得到o2，第1层，");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1){
                    System.out.println("flag = 2,得到o2，第2层，");
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        DeadLockDemo01 deadLockDemo01 = new DeadLockDemo01();
        DeadLockDemo01 deadLockDemo02 = new DeadLockDemo01();
        deadLockDemo01.flag = 0;
        deadLockDemo02.flag = 1;
        Thread t1 = new Thread(deadLockDemo01);
        Thread t2 = new Thread(deadLockDemo02);

        t1.start();


        t2.start();



        System.out.println("main thread over");
    }
}
