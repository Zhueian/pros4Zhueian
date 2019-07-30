package cn.zhueian.design_patterns.billbill.mashibing.observer_pattern.shouxie;

/**
 * Created by qiucy on 2019/7/30.
 * 主题接口，所有主题都要实现这个接口
 */
public interface Subject {

    void registerOb(Ob ob);
    void removeOb(Ob ob);
    void notifyObs();
}
