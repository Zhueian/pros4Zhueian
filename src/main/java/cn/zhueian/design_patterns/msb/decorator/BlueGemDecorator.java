package cn.zhueian.design_patterns.msb.decorator;

/**
 * Created by qiucy on 2019/7/30.
 * 蓝宝石属性+5
 */
public class BlueGemDecorator implements IEquipDecorator{
    private IEquip iEquip;
    public BlueGemDecorator(IEquip iEquip){
        this.iEquip = iEquip;
    }
    @Override
    public int caculateAttack() {
        return 5+iEquip.caculateAttack();
    }

    @Override
    public String desc() {
        return iEquip.desc()+"+ 蓝宝石";
    }
}
