package cn.zhueian.design_patterns.billbill.mashibing.observer_pattern.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by qiucy on 2019/7/30.
 */
public class Ob1 implements Observer{
    public void registerSubject(Observable observable){
        observable.addObserver(this);
    }
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Server3d)
            System.out.println("subjectFor3d's msg --> "+((Server3d) o).getMsg());
        if (o instanceof ServerSSQ)
            System.out.println("subjectForSSQ's msg --> "+((ServerSSQ) o).getMsg());
    }

}
