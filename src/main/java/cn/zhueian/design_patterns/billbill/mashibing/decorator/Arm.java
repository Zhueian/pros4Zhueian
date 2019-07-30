package cn.zhueian.design_patterns.billbill.mashibing.decorator;

/**
 * Created by qiucy on 2019/7/30.
 */
public class Arm implements IEquip{
    @Override
    public int caculateAttack() {
        return 20;
    }

    @Override
    public String desc() {
        return "屠龙刀";
    }
}
