package cn.zhueian.design_patterns.msb.observer_pattern.shouxie;

/**
 * Created by qiucy on 2019/7/30.
 */
public class Test {
    public static void main(String[] args) {
        //模拟一个3d服务号
        Server3Dlottery server = new Server3Dlottery();
        Ob1 ob1 = new Ob1(server);
        Ob2 ob2 = new Ob2(server);
        server.setMsg("20190716的3d号码是：224");
        server.setMsg("20190730的3d号码是：6234");
    }
}
