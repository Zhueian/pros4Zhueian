package cn.zhueian.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by qiucy on 2019/10/17.
 */
public class DateUtil {
    private static Map<String, ThreadLocal<SimpleDateFormat>> sdfMap = new HashMap<>();
    private static final Object lockObj = new Object();
    public static void main(String[] args) {
        Date date = new Date();
        String sout = format(date, "yyyyMMddHHmmss");
        String substring = sout.substring(0, 8);
        System.out.println(sout);
        System.out.println(substring);

    }
    static String format(Date d,String s){
        if (d == null) {
            return null;
        }
        return getSdf(s).format(d);
    }
    private static SimpleDateFormat getSdf(final String pattern) {
        ThreadLocal<SimpleDateFormat> tl = sdfMap.get(pattern);
        // 此处的双重判断和同步是为了防止sdfMap这个单例被多次put重复的sdf
        if (tl == null) {
            synchronized (lockObj) {
                tl = sdfMap.get(pattern);
                if (tl == null) {
                    // 使用ThreadLocal<SimpleDateFormat>替代原来直接new SimpleDateFormat
                    tl = new ThreadLocal<SimpleDateFormat>() {
                        @Override
                        protected SimpleDateFormat initialValue() {
                            return new SimpleDateFormat(pattern);
                        }
                    };
                    sdfMap.put(pattern, tl);
                }
            }
        }

        return tl.get();
    }
}
