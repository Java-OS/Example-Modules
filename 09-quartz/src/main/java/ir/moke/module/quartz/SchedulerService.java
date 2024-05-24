package ir.moke.module.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SchedulerService {
    public static final SchedulerService instance = new SchedulerService();
    private static final Logger logger = LoggerFactory.getLogger(SchedulerService.class);
    private static final SchedulerFactory schedulerFactory = new StdSchedulerFactory();
    private Scheduler scheduler;

    private SchedulerService() {
    }

    public void start() {
        try {
            scheduler = schedulerFactory.getScheduler();
            JobDetail simpleJob = JobBuilder.newJob(SimpleJob.class)
                    .withIdentity("SimpleJob", "G1")
                    .build();

            Trigger Trigger = TriggerBuilder.newTrigger()
                    .forJob(simpleJob)
                    .withIdentity(TriggerKey.triggerKey("MyTrigger"))
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
//                    .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
                    .build();

            scheduler.scheduleJob(simpleJob, Trigger);
            scheduler.start();
        } catch (Exception e) {
            logger.error("Quartz Error", e);
        }
    }


    public void stop() {
        try {
            scheduler.shutdown(true);
        } catch (SchedulerException e) {
            logger.error("Quartz Error", e);
        }
    }
}
