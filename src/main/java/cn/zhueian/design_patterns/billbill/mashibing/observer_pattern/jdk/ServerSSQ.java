package cn.zhueian.design_patterns.billbill.mashibing.observer_pattern.jdk;

import java.util.Observable;

/**
 * Created by qiucy on 2019/7/30.
 */
public class ServerSSQ extends Observable {
    private String msg;
    public String getMsg(){
        return this.msg;
    }
    public void setMsg(String msg){
        this.msg = msg;
        setChanged();
        notifyObservers();
    }
}
