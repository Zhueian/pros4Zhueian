package cn.zhueian.geektime.juc01;

/**
 * Created by qiucy on 2019/9/2.
 * getInstance().new指令直观：
 *  1。分配一块内存M
 *  2。在内存初始化Singleton对象。
 *  3。然后M的地址赋值给instance变量。
 *
 * 实际的指令优化重排后：
 *  1。同上
 *  2。3顺序互换
 *
 *  结果：
 *      假设T1先执行getInstance()的指令2
 *      切换T2：执行getInstance()的第一个if(instance!=null）
 *      T2得到一个instance == null的异常
 */
public class T01_singleton {
    /**
     * volatile能保证可见性和防止指令重排序
     */
    /*volatile*/ static T01_singleton instance;
    static T01_singleton getInstance(){
        if (instance == null){
            synchronized (T01_singleton.class){
                if (instance == null) {
                    instance = new T01_singleton();
                }
            }
        }
        return instance;
    }
}
