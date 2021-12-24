package com.lidong.quartzdemo.bean;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author caolidong
 * @date 2020/8/5
 */
public class InvokeJob implements Job {


    @Override
    public void execute(JobExecutionContext jobExecutionContext) {

        JobDataMap dataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        String url = (String)dataMap.get("url");

        //todo 调用url
//        System.out.println("invoke : " +url);
    }
}
