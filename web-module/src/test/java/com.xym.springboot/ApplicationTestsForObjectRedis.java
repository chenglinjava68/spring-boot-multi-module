package com.xym.springboot;

import com.xym.springboot.domain.RedisUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyApplicationBoot.class)
public class ApplicationTestsForObjectRedis {

    @Autowired
    private RedisTemplate<String, RedisUser> redisTemplate;

    @Test
    public void test() throws Exception {
        // 保存对象
        RedisUser user = new RedisUser("超人", 20);
        redisTemplate.opsForValue().set(user.getUsername(), user);
        user = new RedisUser("蝙蝠侠", 30);
        redisTemplate.opsForValue().set(user.getUsername(), user);
        user = new RedisUser("蜘蛛侠", 40);
        redisTemplate.opsForValue().set(user.getUsername(), user);
        Assert.assertEquals(20, redisTemplate.opsForValue().get("超人").getAge().longValue());
        Assert.assertEquals(30, redisTemplate.opsForValue().get("蝙蝠侠").getAge().longValue());
        Assert.assertEquals(40, redisTemplate.opsForValue().get("蜘蛛侠").getAge().longValue());
    }
}
