package cn.zhueian.design_patterns.msb.strategy;

/**
 * Created by qiucy on 2019/7/30.
 */
public class Test {
    public static void main(String[] args) {
        Role a = new RoleA("A");
        a.setAttackBehavior(new AttackJY())
                .setDefendBehavior(new DefendTBS())
                .setRunBehavior(new RunJCTQ())
                .setDisplayBehavior(new DisplayA());
        a.run();
        a.attack();
        a.defend();
        a.display();
    }
}
