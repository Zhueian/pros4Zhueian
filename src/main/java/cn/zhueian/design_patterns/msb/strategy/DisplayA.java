package cn.zhueian.design_patterns.msb.strategy;

/**
 * Created by qiucy on 2019/7/30.
 */
public class DisplayA implements IDisplayBehavior{
    @Override
    public void display() {
        System.out.println("样子A！");
    }
}
