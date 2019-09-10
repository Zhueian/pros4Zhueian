package cn.zhueian.design_patterns.msb.decorator;

/**
 * Created by qiucy on 2019/7/30.
 */
public class Test {
    public static void main(String[] args) {
        //一个镶嵌2颗红宝石，1颗蓝宝石的鞋子
        System.out.println("一个镶嵌2颗红宝石，1颗蓝宝石的鞋子");
        IEquip iEquip = new RedGemDecorator(new RedGemDecorator(new BlueGemDecorator(new Shoe())));
        System.out.println("攻击力："+iEquip.caculateAttack());
        System.out.println("描述："+iEquip.desc());
        System.out.println("================================================");
        //一个镶嵌1颗红宝石，1颗蓝不是的武器
        IEquip iEquip1 = new RedGemDecorator(new BlueGemDecorator(new Arm()));
        System.out.println("攻击力："+iEquip1.caculateAttack());
        System.out.println("描述："+iEquip1.desc());
    }
}
