package cn.zhueian.design_patterns.msb.decorator;

/**
 * Created by qiucy on 2019/7/30.
 */
public class Wrist implements IEquip{
    @Override
    public int caculateAttack() {
        return 5;
    }

    @Override
    public String desc() {
        return "护腕";
    }
}
