package com.xym.springboot;

import com.xym.springboot.dao.UserMapper;
import com.xym.springboot.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyApplicationBoot.class)
public class ApplicationTestsForMyBatis {

    @Autowired
    private UserMapper userMapper;

    @Test
    @Rollback
    public void findByName() throws Exception {
        userMapper.insert("AAA", 20);
        User u = userMapper.findByName("AAA");
        Assert.assertEquals(20, u.getAge());
    }
}
