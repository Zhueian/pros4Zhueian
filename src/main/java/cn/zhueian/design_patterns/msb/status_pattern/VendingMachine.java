package cn.zhueian.design_patterns.msb.status_pattern;

/**
 * Created by qiucy on 2019/7/31.
 * 自动售货机
 */
public class VendingMachine {
    //已投币
    private final static int HAS_MONEY = 0;
    //未投币
    private final static int NO_MONEY = 1;
    //售出商品
    private final static int SOLD = 2;
    //商品售罄
    private final static int SOLD_OUT = 3;

    private int currentStatus = NO_MONEY;
    //商品数量
    private int count = 0;
    public VendingMachine(int count){
        this.count = count;
        if (count>0) currentStatus = NO_MONEY;
    }

    /**
     * 投入硬币，任何状态用户都可能投币
     */
    public void insertMoney(){
        switch (currentStatus){
            case NO_MONEY:
                currentStatus = HAS_MONEY;
                System.out.println("successfully paid!");
                break;
            case HAS_MONEY:
                System.out.println("had coid,need not pay again!");
                break;
            case SOLD:
                System.out.println("waiting...");
                break;
            case SOLD_OUT:
                System.out.println("good had sold out ,can not pay again!");
                break;
        }
    }

    /**
     * 退币，任何状态用户都可能退币
     */
    public void backMoney(){
        switch (currentStatus){
            case NO_MONEY:
                System.out.println("你未投入硬币");
                break;
            case HAS_MONEY:
                currentStatus = NO_MONEY;
                System.out.println("给您退币了");
                break;
            case SOLD:
                System.out.println("您的商品已发货，请查收");
                break;
            case SOLD_OUT:
                currentStatus = NO_MONEY;
                System.out.println("商品已售罄，已退币");
                break;
        }
    }
    /**
     *转动手柄购买，任何状态用户都可能转动手柄
     */
    public void changeCrank(){
        switch(currentStatus){
            case NO_MONEY:
                System.out.println("请先投币");
                break;
            case HAS_MONEY:
                System.out.println("正在出商品");
                currentStatus = SOLD;
                dispend();
                break;
            case SOLD:
                System.out.println("正在出商品，现在改变主意没用了");
                break;
            case SOLD_OUT:
                System.out.println("商品已经售罄,别几把转了");
                break;
        }
    }

    /**
     * 发放商品。。。。。好烦
     */
    public void dispend(){
        switch(currentStatus){
            case NO_MONEY:
            case HAS_MONEY:
            case SOLD_OUT:
                throw new IllegalStateException("非法状态");
            case SOLD:
                count --;
                System.out.println();
        }
    }
}
