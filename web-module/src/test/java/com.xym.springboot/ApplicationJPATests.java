package com.xym.springboot;

import com.xym.springboot.dao.UserRepository;
import com.xym.springboot.domain.JPAUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyApplicationBoot.class)
public class ApplicationJPATests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() throws Exception {
        // 创建10条记录
        userRepository.save(new JPAUser("AAA", 10));
        userRepository.save(new JPAUser("BBB", 20));
        userRepository.save(new JPAUser("CCC", 30));
        userRepository.save(new JPAUser("DDD", 40));
        userRepository.save(new JPAUser("EEE", 50));
        userRepository.save(new JPAUser("FFF", 60));
        userRepository.save(new JPAUser("GGG", 70));
        userRepository.save(new JPAUser("HHH", 80));
        userRepository.save(new JPAUser("III", 90));
        userRepository.save(new JPAUser("JJJ", 100));
        // 测试findAll, 查询所有记录
        Assert.assertEquals(10, userRepository.findAll().size());
        // 测试findByName, 查询姓名为FFF的JPAUser
        Assert.assertEquals(60, userRepository.findByName("FFF").getAge().longValue());
        // 测试findJPAUser, 查询姓名为FFF的JPAUser
        Assert.assertEquals(60, userRepository.findJPAUser("FFF").getAge().longValue());
        // 测试findByNameAndAge, 查询姓名为FFF并且年龄为60的JPAUser
        Assert.assertEquals("FFF", userRepository.findByNameAndAge("FFF", 60).getName());
        // 测试删除姓名为AAA的JPAUser
        userRepository.delete(userRepository.findByName("AAA"));
        // 测试findAll, 查询所有记录, 验证上面的删除是否成功
        Assert.assertEquals(9, userRepository.findAll().size());
    }


}
