package com.xym.springboot;

import com.xym.springboot.async.Tasks2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyApplicationBoot.class)
@EnableAsync//启用异步
public class ApplicationTestsForASync {

    @Autowired
    private Tasks2 tasks2;

    @Test
    public void test() throws Exception {
        tasks2.doTaskOne();
        tasks2.doTaskTwo();
        tasks2.doTaskThree();

        Thread.sleep(7000);
    }

}
