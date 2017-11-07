package com.xym.springboot;

import com.xym.springboot.async.Tasks;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyApplicationBoot.class)
public class ApplicationTestsForSync {

    @Autowired
    private Tasks tasks;

    @Test
    public void test() throws Exception {
        tasks.doTaskOne();
        tasks.doTaskTwo();
        tasks.doTaskThree();
    }

}
