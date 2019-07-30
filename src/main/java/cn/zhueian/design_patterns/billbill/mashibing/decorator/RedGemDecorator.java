package cn.zhueian.design_patterns.billbill.mashibing.decorator;

/**
 * Created by qiucy on 2019/7/30.
 * 黄宝石+20属性
 */
public class RedGemDecorator implements IEquipDecorator{

    private IEquip iEquip;
    public RedGemDecorator(IEquip iEquip){
        this.iEquip = iEquip;
    }

    @Override
    public int caculateAttack() {
        return 20+iEquip.caculateAttack();
    }

    @Override
    public String desc() {
        return iEquip.desc()+" + 红宝石";
    }
}
