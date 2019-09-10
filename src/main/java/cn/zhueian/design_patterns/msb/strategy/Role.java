package cn.zhueian.design_patterns.msb.strategy;

/**
 * Created by qiucy on 2019/7/30.
 * 游戏角色超类
 */
public abstract class Role {
    protected String name;
//    protected abstract void display();
//    protected abstract void run();
//    protected abstract void attack();
//    protected abstract void defend();
    protected IDefendBehavior defendBehavior;
    protected IAttackBehavior attackBehavior;
    protected IRunBehaivor runBehaivor;
    protected IDisplayBehavior displayBehavior;

    protected Role setDefendBehavior(IDefendBehavior defendBehavior){
        this.defendBehavior = defendBehavior;
        return this;
    }

    protected Role setAttackBehavior(IAttackBehavior attackBehavior){
        this.attackBehavior = attackBehavior;
        return this;
    }

    protected Role setDisplayBehavior(IDisplayBehavior displayBehavior){
        this.displayBehavior = displayBehavior;
        return this;
    }

    protected Role setRunBehavior(IRunBehaivor runBehavior){
        this.runBehaivor = runBehavior;
        return this;
    }

    protected void attack(){
        attackBehavior.attack();
    }

    protected void defend(){
        defendBehavior.defend();
    }

    protected void display(){
        displayBehavior.display();
    }
    protected void run(){
        runBehaivor.run();
    }
}
