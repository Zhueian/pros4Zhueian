package cn.zhueian.geektime.juc01;

/**
 * Created by qiucy on 2019/9/2.
 */
public class T03_运行时无锁 {
    int c = 0;
    int get(){
        synchronized (new Object()){
            return c;
        }
    }
    void add(){
        synchronized (new Object()){
            ++c;
        }
    }
}
