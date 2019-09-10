package cn.zhueian.geektime.juc01;

/**
 * Created by qiucy on 2019/9/2.
 */
public class T02_volatitledemo {
    int x = 0;
    volatile boolean v = false;
    public void w(){
        x = 1;
        v = true;
    }
    public void r(){
        if (v){
            //x == ?? 0，1   jdk1.5前都有可能
        }
    }
}
