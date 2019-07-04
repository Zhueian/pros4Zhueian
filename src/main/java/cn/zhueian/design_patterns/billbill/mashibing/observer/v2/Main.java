package cn.zhueian.design_patterns.billbill.mashibing.observer.v2;

/**
 * @Auther: qiucy
 * @Date: 2019-05-21 21:54
 * @Description:
 */
public class Main {
    public static void main(String[] args) {

    }
}
class Dad{
    public void feed(){

    }
}
class Dog{
    public void wang(){

    }
}
class Mum{
    public void hug(){

    }
}
class Baby{
    private Boolean cry = false;
    private Dad d = new Dad();
    private Mum m = new Mum();
    private Dog dog = new Dog();
    public void weakup(){
        cry = true;
        d.feed();
        m.hug();
        dog.wang();
    }
}
