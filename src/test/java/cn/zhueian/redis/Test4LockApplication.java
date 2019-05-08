package cn.zhueian.redis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: qiucy
 * @Date: 2019-04-16 14:35
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LockApplication.class)
public class Test4LockApplication {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Test
    public void test() throws Exception{
        stringRedisTemplate.opsForValue().set("stock","50");
        Assert.assertEquals("50",stringRedisTemplate.opsForValue().get("stock"));
    }
}
