package com.xym.springboot;

import com.xym.springboot.dao.UserMapper2;
import com.xym.springboot.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyApplicationBoot.class)
public class ApplicationTestsForMyBatis2 {

    @Autowired
    private UserMapper2 userMapper2;

    @Test
    @Rollback
    public void testUserMapper() throws Exception {
        // insert一条数据，并select出来验证
        userMapper2.insert("AAA", 20);
        User u = userMapper2.findByName("AAA");
        Assert.assertEquals(20, u.getAge());
        // update一条数据，并select出来验证
        u.setAge(30);
        userMapper2.update(u);
        u = userMapper2.findByName("AAA");
        Assert.assertEquals(30, u.getAge());
        // 删除这条数据，并select验证
        userMapper2.delete(u.getId());
        u = userMapper2.findByName("AAA");
        Assert.assertEquals(null, u);
    }

    @Test
    @Rollback
    public void testUserMapper2() throws Exception {
        List<User> userList = userMapper2.findAll();
        for(User user : userList) {
            Assert.assertEquals(null, user.getId());
            Assert.assertNotEquals(null, user.getName());
        }
    }
}
