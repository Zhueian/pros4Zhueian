package cn.zhueian.design_patterns.msb.observer_pattern.shouxie;

/**
 * Created by qiucy on 2019/7/30.
 */
public class Ob1 implements Ob{
    private Subject sub;
    public Ob1(Subject sub){
        this.sub = sub;
        sub.registerOb(this);
    }
    @Override
    public void update(String msg) {
        System.out.println("ob1 得到 3d号码 --》 "+msg);
    }
}
