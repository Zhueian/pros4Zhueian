package cn.zhueian.design_patterns.billbill.mashibing.observer_pattern.shouxie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiucy on 2019/7/30.
 */
public class Server3Dlottery implements Subject {
    private List<Ob> obs = new ArrayList<>();
    private String msg;
    @Override
    public void registerOb(Ob ob) {
        obs.add(ob);
    }

    @Override
    public void removeOb(Ob ob) {
        int i = obs.indexOf(ob);
        if (i>=0) obs.remove(i);
    }

    @Override
    public void notifyObs() {
        obs.forEach(o->o.update(msg));
    }

    public void setMsg(String msg){
        this.msg = msg;
        notifyObs();
    }
}
