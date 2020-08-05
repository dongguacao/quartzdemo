package com.lidong.quartzdemo.config;

import com.lidong.quartzdemo.bean.InvokeJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author caolidong
 * @date 2020/8/5
 */
@Component
public class QuartzConfig {
    private static final Logger logger = LoggerFactory.getLogger(QuartzConfig.class);


    @Bean
    public Scheduler startJobs() throws SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler stdScheduler = schedulerFactory.getScheduler();
        try {
            stdScheduler.start();
        } catch (SchedulerException e) {
            logger.error("启动stdScheduler失败",e);
        }
        // todo 从数据库拿出来所有的 url和其对应的时间
        Map<String,String> urlAndCorns = new HashMap<>();
        urlAndCorns.put("aa","* * * * * ? *");
        urlAndCorns.put("bb","* * * * * ? *");
        //
        for (Map.Entry<String, String> urlAndCorn : urlAndCorns.entrySet()) {
            //创建jobdetail
            JobDetail jobDetail = JobBuilder.newJob(InvokeJob.class).build();
            jobDetail.getJobDataMap().put("url",urlAndCorn.getKey());
            //创建tigger
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(urlAndCorn.getValue());
            CronTrigger trigger = TriggerBuilder.newTrigger().withSchedule(scheduleBuilder).build();

            try {
                stdScheduler.scheduleJob(jobDetail, trigger);
                if (!stdScheduler.isStarted()) {
                    stdScheduler.start();
                }
            } catch (SchedulerException e) {
                logger.error("创建批处理任务失败",e);
            }

        }
        return stdScheduler;
    }

}
