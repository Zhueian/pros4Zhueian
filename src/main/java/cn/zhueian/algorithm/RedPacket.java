package cn.zhueian.algorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by qiucy on 2019/8/14.
 * Function: 模拟微信红包生成，以分为单位
 */
public class RedPacket {
    /**
     * 红包最小金额1分钱
     */
    private static final int MIN_MONEY = 1;
    private static final int MAX_MONEY = 200*100;
    private static final int LESS = -1;
    private static final int MORE = -2;
    private static final int OK = 1;
    /**
     * 最大红包是平均值的TIMES倍，防止某一次分配红包过大
     */
    private static final double TIMES = 2.1F;
    private int recursiveCount = 0;
    public List<Integer> splitRP(int money,int count){
        List<Integer> moneys = new LinkedList<>();
        //金额检查，如果最大红包 * 个数 《 总金额：调小最大红包/调大最小红包
        if (MAX_MONEY * count <= money) return moneys;
        //计算最大红包
        int max = (int)((money / count) * TIMES);
        max = max > MAX_MONEY ? MAX_MONEY : max;
        for (int i = 0; i < count && recursiveCount<1000; i++) {
            int rp = randomRP(money,MIN_MONEY,max,count-i);
            moneys.add(rp);
            money -= rp;
        }
        return moneys;
    }

    private int randomRP(int money, int min, int max, int count) {
        //只有一个红包
        if (count == 1) return money;
        if (min == max) return min;
        //如果最大金额大于剩余金额，则用剩余金额，因为这个money每分配一次都会减少
        max = max > money ? money:max;
        //在min-max之间生成一个随机数
        int rp = (int)(Math.random()*(max - min) * min);
        int remine = money - rp;
        int status = checkMoney(remine,count-1);
        //正常金额
        if (OK == status) return rp;
        //如果生成的金额不合法，则递归重新生成
        else{
            recursiveCount++;
            if (LESS == status) return randomRP(money,min,rp,count);
            if (MORE == status) return randomRP(money,rp,max,count);
        }
        return rp;
    }

    /**
     * 校验剩余金额的平均值是否在，最小值和最大值这个范围
     * @param remine
     * @param count
     * @return
     */
    private int checkMoney(int remine, int count) {
        double avg = remine/count;
        if (avg < MIN_MONEY) return LESS;
        if (avg > MAX_MONEY) return MORE;
        return OK;
    }

    public static void main(String[] args) {
        RedPacket test = new RedPacket();
        List<Integer> rps = test.splitRP(20000, 100);
        System.out.println(rps);
        int sum = 0;
        sum = rps.stream().reduce(Integer::sum).get();
        System.out.println(sum);
        System.out.println(test.recursiveCount);
    }
}