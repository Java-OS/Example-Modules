package ir.moke.module.timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TimerTask;

public class TaskService extends TimerTask {
    private static final Logger logger = LoggerFactory.getLogger(TaskService.class);

    @Override
    public void run() {
        logger.info("Scheduler service executed");
    }
}
