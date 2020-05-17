package com.soft1851.springboot.schedule.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author Zeng
 * @ClassName HelloJob
 * @Description TOOD
 * @Date 2020/5/16
 * @Version 1.0
 **/
public class HelloJob implements Job {
    private int count;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Hello Job!");
        count++;
    }

    public int getCount() {
        return count;
    }
}
