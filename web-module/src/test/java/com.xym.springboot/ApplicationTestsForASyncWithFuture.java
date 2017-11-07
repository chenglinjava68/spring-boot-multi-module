package com.xym.springboot;

import com.xym.springboot.async.Tasks2Future;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.Future;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyApplicationBoot.class)
@EnableAsync//启用异步
public class ApplicationTestsForASyncWithFuture {

    @Autowired
    private Tasks2Future tasks2Future;

    @Test
    public void test() throws Exception {
        long start = System.currentTimeMillis();
        Future<String> task1 = tasks2Future.doTaskOne();
        Future<String> task2 = tasks2Future.doTaskTwo();
        Future<String> task3 = tasks2Future.doTaskThree();
        while (true) {
            if (task1.isDone() && task2.isDone() && task3.isDone()) {
                // 三个任务都调用完成，退出循环等待
                break;
            }
            Thread.sleep(1000);
        }
        long end = System.currentTimeMillis();
        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }

}
