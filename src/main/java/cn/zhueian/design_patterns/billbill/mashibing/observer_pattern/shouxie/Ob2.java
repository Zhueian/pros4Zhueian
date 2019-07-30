package cn.zhueian.design_patterns.billbill.mashibing.observer_pattern.shouxie;

/**
 * Created by qiucy on 2019/7/30.
 */
public class Ob2 implements Ob{
    private Subject sub;
    public Ob2(Subject sub){
        this.sub = sub;
        sub.registerOb(this);
    }
    @Override
    public void update(String msg) {
        System.out.println("ob2 得到3d号码 --》 "+msg);
    }
}
