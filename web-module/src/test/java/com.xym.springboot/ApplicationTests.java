package com.xym.springboot;

import com.xym.springboot.service.MySqlUserService;
import com.xym.springboot.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyApplicationBoot.class)
public class ApplicationTests {

    @Autowired
    private MySqlUserService mySqlUserService;

    @Before
    public void setUp() {
        // 准备，清空user表
        mySqlUserService.deleteAllUsers();
    }

    @Test
    public void test() throws Exception {
        // 插入5个用户
        mySqlUserService.create("a", 1);
        mySqlUserService.create("b", 2);
        mySqlUserService.create("c", 3);
        mySqlUserService.create("d", 4);
        mySqlUserService.create("e", 5);
        // 查数据库，应该有5个用户
        Assert.assertEquals(5, mySqlUserService.getAllUsers().intValue());
        // 删除两个用户
        mySqlUserService.deleteByName("a");
        mySqlUserService.deleteByName("e");
        // 查数据库，应该有5个用户
        Assert.assertEquals(3, mySqlUserService.getAllUsers().intValue());
    }
}
