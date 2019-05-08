package cn.zhueian.highConcurrentMultithreading.shibingMa.billbill_mashibing.step03;

/**
 * @Auther: qiucy
 * @Date: 2019-04-24 12:26
 * @Description:最好的并发单例
 *  既不用加锁，也能懒加载
 *  bug:序列化和反射会有问题
 */
public class BestSingleton {
    private BestSingleton(){
        System.out.println("init BestSingleton");
    }
    private static class Inner{
        private static BestSingleton s = new BestSingleton();
    }
    public static BestSingleton getInstance(){
        return Inner.s;
    }

    public static void main(String[] args) {
        System.out.println(BestSingleton.getInstance());
        System.out.println(BestSingleton.getInstance());
        System.out.println(BestSingleton.getInstance());
        System.out.println("==============");
        for (int i = 0; i < 4; i++) {
            new Thread(() -> {
                System.out.println(BestSingleton.getInstance());
            },"t_"+i).start();
        }
    }
}
