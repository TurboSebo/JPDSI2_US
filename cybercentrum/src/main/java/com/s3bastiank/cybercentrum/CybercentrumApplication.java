package com.s3bastiank.cybercentrum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)//nie wiem czemu pyta o logowanie wtf?
public class CybercentrumApplication {

	public static void main(String[] args) {
		SpringApplication.run(CybercentrumApplication.class, args);
	}

}
