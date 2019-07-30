package cn.zhueian.design_patterns.billbill.mashibing.observer_pattern.jdk;

/**
 * Created by qiucy on 2019/7/30.
 */
public class Test {
    public static void main(String[] args) {
        Server3d server3d = new Server3d();
        ServerSSQ serverSSQ = new ServerSSQ();
        Ob1 ob1 = new Ob1();
        ob1.registerSubject(server3d);
        ob1.registerSubject(serverSSQ);

        server3d.setMsg("hello 3d'nums:110");
        serverSSQ.setMsg("ssq's nums : 12.235.`21.543.12");
    }
}
