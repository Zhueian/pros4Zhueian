package cn.zhueian.highConcurrentMultithreading.shibingMa.billbill_mashibing.step04;

import java.util.concurrent.Callable;

/**
 * @Auther: qiucy
 * @Date: 2019-04-28 13:33
 * @Description:
 *  method->call()-><V>;
 *  computes a result,or throws an exception if unable to do so.
 *  run() 是不能throws exception，只能try->catch,因为此方法是被定义为重写的;
 *  call() 可以throws exception;
 *
 */
public class T03_Callable {
    public static void main(String[] args) {
        //注意区别
        Callable c = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return null;
            }
        };
        System.out.println("=============================");
        Runnable r = new Runnable() {
            @Override
            public void run() {

            }
        };
    }
}
