package com.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.career.controller.MemberController;

@Component
public class Scheduler {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);	
	
	@Scheduled(cron = "1 * * * * *")
	public void batchTest() {
		Date date = new Date();
		SimpleDateFormat strFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		logger.info("Date : "+strFormat.format(date));
	}
}
