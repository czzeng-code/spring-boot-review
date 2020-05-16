package com.soft1851.springboot.schedule.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Zeng
 * @ClassName Task1
 * @Description TOOD
 * @Date 2020/5/14
 * @Version 1.0
 **/
//@Component
public class Task1 {
    private int count = 0;

    @Scheduled(cron = "*/5 * * * * ?")
    private void process() {
        System.out.println("this is scheduler task running " + (count++));
    }
}
