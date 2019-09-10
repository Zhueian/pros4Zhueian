package cn.zhueian.design_patterns.msb.decorator;

/**
 * Created by qiucy on 2019/7/30.
 * 黄宝石+10属性
 */
public class YellowGemDecorator implements IEquipDecorator{

    private IEquip iEquip;
    public YellowGemDecorator(IEquip iEquip){
        this.iEquip = iEquip;
    }

    @Override
    public int caculateAttack() {
        return 10+iEquip.caculateAttack();
    }

    @Override
    public String desc() {
        return iEquip.desc()+" + 黄宝石";
    }
}
