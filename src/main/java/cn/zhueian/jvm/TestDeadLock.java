package cn.zhueian.jvm;


/**
 * @Auther: qiucy
 * @Date: 2019-04-15 16:45
 * @Description:
 */
public class TestDeadLock {
    private static  Object o1 = new Object();
    private static  Object o2 = new Object();

    public static void main(String[] args) {
        new Thread(new Thread1()).start();
        new Thread(new Thread2()).start();

    }
    private static class Thread1 implements Runnable{

        public void run() {
            synchronized (o1){
                System.out.println("Thread1 get o1/lock1");
                try{
                    //停顿2秒让thread2线程拿到o2锁
                    Thread.sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            synchronized (o2){
                System.out.println("Thread1 get o2/lock1");
            }
        }
    }private static class Thread2 implements Runnable{

        public void run() {
            synchronized (o2){
                System.out.println("Thread1 get o1/lock1");
                try{
                    //停顿2秒让thread1线程拿到o2锁
                    Thread.sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            synchronized (o1){
                System.out.println("Thread1 get o2/lock1");
                System.out.println("");
            }
        }
    }
}
