package com.example.SmartNotify;

import com.example.SmartNotify.Models.Notificationdata	;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync

@SpringBootApplication
public class SmartNotifyApplication {

	public static void main(String[] args) {

		SpringApplication.run(SmartNotifyApplication.class, args);
	}

}
