package cn.zhueian.redis;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: qiucy
 * @Date: 2019-04-16 14:21
 * @Description:基于分布式锁的incr setnx redisson的方式
 */
@SpringBootApplication
@RestController
public class LockApplication {
    @Autowired
    private Redisson redisson;
    private static Object lock = new Object();

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public static void main(String[] args) {
        SpringApplication.run(LockApplication.class,args);
    }
    @RequestMapping("/deduct-stock")
    public String deductStock(){

        int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
        if(stock > 0){
            stringRedisTemplate.opsForValue().set("stock",stock-1+"");
            System.out.println("扣减成功，现库存为："+(stock - 1));
            return "succefull";
        }else{
            System.out.println("扣减成功，现库存为："+(stock));
            return "fail";
        }
    }
    @RequestMapping("/deduct-stock2")
    public void deductStock2(){

        int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
        if(stock > 0){
            stringRedisTemplate.opsForValue().set("stock",stock-1+"");
            System.out.println("扣减成功，现库存为："+(stock - 1));
        }else{
            System.out.println("扣减成功，现库存为："+(stock));
        }
    }
    @RequestMapping("/deduct-stock3")
    public void deductStock3(){

        synchronized (lock){
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
            if(stock > 0){
                stringRedisTemplate.opsForValue().set("stock",stock-1+"");
                System.out.println("扣减成功，现库存为："+(stock - 1));
                System.out.println();
            }else{
                System.out.println("扣减成功，现库存为："+(stock));
            }
        }
    }

    /**
     * 用INCR实现，性能最差的redis分布式锁
     */
    @RequestMapping("/deduct-stock4")
    public void deductStock4(){
        //try,要是throw了，那么锁有问题了，永远没有1，即是所有线程永远扣减不到库存即便库存还有很多
        //所以finally执行的是释放锁，无论throw exception与否。
        try{
            //加锁
            long lockNum = stringRedisTemplate.opsForValue().increment("lockNum",1);

            //扣减逻辑期间，pro宕机了，断网了，停电了，核平了，即是Error了；
            //再重启，的话也是拿不到锁，跟try注释一样道理，finally不够完美；
            //估算再极端也不会超过十秒来执行扣库存操作；
            //FIXME 但是由于网路波动，service执行到了11s还在慢慢往下走，但是已经·过期了，
            // 第二个线程会拿到锁，即是有两个线程拿到锁并且并行执行，就会有两个释放锁的-1操作,
            // 一秒成千上万的并发，错综复杂就别想恢复这把锁了！请看method deductstock5
            stringRedisTemplate.expire("lockNum",10, TimeUnit.SECONDS);
            if(lockNum == 1){
                int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
                if(stock > 0){
                    //又很多逻辑：orderService.callback();stockService.deduct();userService.pieceSuccess();
                    stringRedisTemplate.opsForValue().set("stock",stock-1+"");
                    System.out.println("sotck enough!!:"+stringRedisTemplate.opsForValue().get("stock"));
                }else{
                    System.out.println("stock is not enough!!:"+stringRedisTemplate.opsForValue().get("stock"));
                }
//            //这里释放锁有问题？
//            stringRedisTemplate.opsForValue().increment("lockNum",-1);
            }
        }finally {
            //这里释放锁有问题？要是ramp-up设置为0，会只卖到几个，但不会超卖了；设置ramp-up大于0可以解决
            //不是先来下单先买到了，，不是时间顺序的公平锁
            //TODO 这里减一释放锁失败了，有exception或者erro怎么办？？
            stringRedisTemplate.opsForValue().increment("lockNum",-1);
        }

    }

    /**
     * 用INCR实现+redisson，性能最差的redis分布式锁
     */
    @RequestMapping("/deduct-stock5")
    public void deductStock5(){
        //锁可能会跟之前的demo的lockNum01重复，报错
        //ERROR running script (call to f_xx0asqwdkajsncjknaks2131n12kk12n)...
        RLock rLock = redisson.getLock("lockNum01");
        try{
            //一种watchDog守护线程一样，redisson,lock在进入锁之后的操作线程会分支一个守护线程
            // 用wihle每十秒自旋检查时候还拥有锁，是过期时间+十秒
            rLock.lock();
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
            if(stock > 0){
                stringRedisTemplate.opsForValue().set("stock",stock-1+"");
                System.out.println("sotck enough!!:"+stringRedisTemplate.opsForValue().get("stock"));
            }else{
                System.out.println("stock is not enough!!:"+stringRedisTemplate.opsForValue().get("stock"));
                System.out.println();
            }
        }finally {
            rLock.unlock();
        }

    }

    /**
     * 用setNX方式写redis锁
     * @return
     */
    @ResponseBody
    @RequestMapping("/deductStock-setNX")
    public String deductStockBySetNX(){
        String lock = "lockkey";
        String threadvalue = UUID.randomUUID().toString();
        try{
            //setNX(k,v,nx,time),底层setnx+expire原子性的。
//            Boolean lockvalue = stringRedisTemplate.opsForValue().
//                    setIfAbsent(lock, threadvalue,10,TimeUnit.SECONDS);
            Boolean lockvalue = stringRedisTemplate.opsForValue().
                    setIfAbsent(lock, threadvalue);
            stringRedisTemplate.expire(lock,10,TimeUnit.SECONDS);
            if(!lockvalue){
                return "";
            }
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
            if(stock > 0){
                int realStock = stock - 1;
                stringRedisTemplate.opsForValue().set("stock",realStock+"");
                System.out.println("扣减成功剩余库存为："+realStock);
            }else{
                System.out.println("扣减失败，库存不足");
            }
        }finally {
            //超时未际时一个线程一个锁，和一个钥匙（解锁）
            if(threadvalue.equals(stringRedisTemplate.opsForValue().get(lock))){
                //释放锁
                stringRedisTemplate.delete(lock);
            }

        }
        return "end";
    }

    @Bean
    @ConditionalOnMissingBean(StringRedisTemplate.class)
    //TODO 这注解干哈用的
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory){
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    @Bean
    public Redisson redisson(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379").setDatabase(0);
        return (Redisson) Redisson.create(config);
    }
}
