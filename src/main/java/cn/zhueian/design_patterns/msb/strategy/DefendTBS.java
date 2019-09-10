package cn.zhueian.design_patterns.msb.strategy;

/**
 * Created by qiucy on 2019/7/30.
 */
public class DefendTBS implements IDefendBehavior{
    @Override
    public void defend() {
        System.out.println("铁布衫！");
    }
}
