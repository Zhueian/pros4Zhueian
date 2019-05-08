package cn.zhueian.jvm;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @Auther: qiucy
 * @Date: 2019-04-15 15:26
 * @Description:
 */
public class TestJvmOutOfMemory {
    /**
     * 模拟内存溢出
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<Object>();
        for (int i = 0; i < 1000000;i++){
            String s = "";
            for (int j = 0; j < 1000; j++) {
                s = UUID.randomUUID().toString();
            }
            objects.add(s);
        }
        System.out.println("ok!!~");
    }
}
