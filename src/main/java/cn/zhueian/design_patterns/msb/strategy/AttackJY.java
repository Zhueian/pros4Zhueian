package cn.zhueian.design_patterns.msb.strategy;

/**
 * Created by qiucy on 2019/7/30.
 */
public class AttackJY implements IAttackBehavior{
    @Override
    public void attack() {
        System.out.println("九阳神功！");
    }
}
