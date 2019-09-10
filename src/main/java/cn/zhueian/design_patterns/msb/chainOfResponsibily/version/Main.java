package cn.zhueian.design_patterns.msb.chainOfResponsibily.version;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: qiucy
 * @Date: 2019-04-26 18:34
 * @Description:
 */
public class Main {
    //demo：过滤敏感信息
    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("大家好:),<script>,欢迎访问mashibing，大家都是996");
        //处理msg
        FilterChain fc = new FilterChain();
        fc.add(new HtmlFilter()).add(new SentiveFilter());
        fc.doFilter(msg);
        FilterChain fc2 = new FilterChain();
        fc2.add(new FaceFilter()).add(new UrlFilter());
        fc.add(fc2);
        fc.doFilter(msg);
        System.out.println(msg);

    }
}
class Msg{
    String name;
    String msg;
    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }
    @Override
    public String toString() {
        return "Msg{" +
                "name='" + name + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
interface Filter{
    boolean doFilter(Msg msg);
}
class HtmlFilter implements Filter{
    @Override
    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r.replaceAll("<","[");
        r.replaceAll(">","]");
        msg.setMsg(r);
        //if()reture false;
        return true;
    }
}
class SentiveFilter implements Filter{
    @Override
    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r.replaceAll("996","995");
        msg.setMsg(r);
        return false;
    }
}
class FaceFilter implements Filter{
    @Override
    public boolean doFilter(Msg msg) {
        return true;
    }
}
class UrlFilter implements Filter{
    @Override
    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        return true;
    }
}

class FilterChain implements Filter{
    List<Filter> filters = new ArrayList<>();
    public FilterChain add(Filter f){
        filters.add(f);
        return this;
    }
    @Override
    public boolean doFilter(Msg msg) {
        for (Filter f:filters){
            if(!f.doFilter(msg)) return false;
        }
        return true;
    }
}