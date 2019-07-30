package cn.zhueian.design_patterns.billbill.mashibing.decorator;

/**
 * Created by qiucy on 2019/7/30.
 */
public class Ring implements IEquip{
    @Override
    public int caculateAttack() {
        return 5;
    }

    @Override
    public String desc() {
        return "魔戒";
    }
}
