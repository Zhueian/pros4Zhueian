package cn.zhueian.highConcurrentMultithreading.shibingMa.msb.step01;

/**
 * @Auther: qiucy
 * @Date: 2019-04-23 14:45
 * @Description:不要以字符串常量作为锁，非要的话用：String lock = new String("lock");
 *  这种锁的问题很隐蔽，jetty就有这个bug；jar包类库中，锁了个大众词汇，，，debug了半天
 */
public class Syn_StringLock {
    //s1 == s2 -> true,字符串常量池
    String s1 = "hello";
    String s2 = "hello";
    void m1(){
        synchronized (s1){

        }
    }
    void m2(){
        synchronized (s2){

        }
    }
}
