package com.haseeb.upwork_rss_scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class UpworkRssSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UpworkRssSchedulerApplication.class, args);
	}

}
