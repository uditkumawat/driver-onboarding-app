package com.uditkumawat.craftproject;

import com.uditkumawat.craftproject.config.FileStorageProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class DriverOnboardingApplication {

	private static final Logger logger = LoggerFactory.getLogger(DriverOnboardingApplication.class);

	public static void main(String[] args) {
		logger.info("Driver onboarding service is starting");
		SpringApplication.run(DriverOnboardingApplication.class);
		logger.info("Service started");
	}
}
