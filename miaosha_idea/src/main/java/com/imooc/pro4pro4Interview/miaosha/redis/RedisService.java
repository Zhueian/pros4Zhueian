package com.imooc.pro4pro4Interview.miaosha.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.Resource;

/**
 * @Auther: qiucy
 * @Date: 2019-05-07 15:06
 * @Description:
 */
@Service
public class RedisService {

    @Resource
    JedisPool jedisPool;

    public <T> T get(String key,Class<T> clazz){
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            String str = jedis.get(key);
            return str2Bean(str,clazz);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("jedis excetion!..");
            return null;
        }finally {
            release(jedis); 
        }
    }

    public <T> Boolean set(String key,T value){
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            String json = bean2str(value);
            if(json == null || json.length() <= 0){
                return false;
            }
            jedis.set(key,json);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("jedis excetion!..");
            return false;
        }finally {
            release(jedis);
        }
    }

    private <T> String bean2str(T value) {
        if(value == null) return null;

        Class<?> clazz = value.getClass();

        if(clazz == int.class || clazz == Integer.class) return value+"";

        else if(clazz == String.class) return (String)value;

        else if (clazz == long.class || clazz == Long.class) return value+"";

        else return JSON.toJSONString(value);

    }

    private <T> T str2Bean(String str,Class<T> clazz) {

        return null;
    }

    private void release(Jedis jedis) {
        if (jedis != null){
            jedis.close();
        }
    }

    @Bean
    public JedisPool JedisPoolFactory(){
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(10);
        poolConfig.setMaxTotal(20);
        poolConfig.setMaxWaitMillis(3*1000);

        JedisPool jedisPool = new JedisPool(
                poolConfig,"127.0.0.1",6379,3*1000,"",0);
        return jedisPool;
    }
}
