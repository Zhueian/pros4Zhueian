package cn.zhueian.design_patterns.billbill.mashibing.strategy;

/**
 * Created by qiucy on 2019/7/30.
 */
public class AttackJY implements IAttackBehavior{
    @Override
    public void attack() {
        System.out.println("九阳神功！");
    }
}
