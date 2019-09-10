package cn.zhueian.highConcurrentMultithreading.shibingMa.msb.step04;

import java.util.concurrent.Executor;

/**
 * @Auther: qiucy
 * @Date: 2019-04-27 20:26
 * @Description:
 *  Excutor是顶级接口,执行者！
 *  当然jdk已经写好了很多Executor实现了，不必重复造轮子
 */
public class T01_MyExcutor implements Executor {
    public static void main(String[] args) {
//        T01_MyExcutor e = new T01_MyExcutor();
//        e.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("sdasd");
//            }
//        });
        //lamda表达式
        new T01_MyExcutor().execute(() -> {
            System.out.println(Thread.currentThread().getName()+"-asdads");
        });
    }

    @Override
    public void execute(Runnable command) {
        //新建线程调用,但是没有start
//        new Thread(command).run();
        //启动start
        new Thread(command).start();
        //等同于简单的方法调用
//        command.run();
    }
}
