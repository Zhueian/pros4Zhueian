package cn.zhueian.design_patterns.billbill.mashibing.observer.v1;

/**
 * @Auther: qiucy
 * @Date: 2019-05-21 21:52
 * @Description:加一个观察这Dad到被观察着Baby中
 */
public class Main {
    public static void main(String[] args) {

    }
}
class Dad{
    public void feed(){
        System.out.println("dad feeding ..");
    }
}
class Baby{
    private boolean cry = false;
    private Dad d = new Dad();
    public boolean isCry(){
        return cry;
    }
    public void weak(){
        cry = false;
        d.feed();
    }
}
