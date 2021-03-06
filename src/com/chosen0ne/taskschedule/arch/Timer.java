package com.chosen0ne.taskschedule.arch;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import com.chosen0ne.taskschedule.os.Scheduler;

public class Timer implements Runnable{
	private static Logger logger = Logger.getLogger(Timer.class.getName());

	public Timer(){
		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
		
		executor.scheduleAtFixedRate(this, 0, 5000, TimeUnit.MILLISECONDS);
	}

	@Override
	public void run() {
		logger.info("Scheduler ticks");
		
		Scheduler.getInstance().schedule();
	}
}
