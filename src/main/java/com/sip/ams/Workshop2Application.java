package com.sip.ams;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.sip.ams.controllers.ArticleController;
import com.sip.ams.controllers.ProviderController;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import javax.mail.MessagingException;
import java.io.IOException;

@SpringBootApplication
public class Workshop2Application extends SpringBootServletInitializer implements CommandLineRunner{

	@Autowired
	private JavaMailSender javaMailSender;

	void sendEmail() {

		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("majdddineoueslati@gmail.com");

		msg.setSubject("Testing from Spring Boot");
		msg.setText("Hello World \n Spring Boot Email");

		javaMailSender.send(msg);

	}

	@Override
	public void run(String... args) throws MessagingException, IOException {

		System.out.println("Sending Email...");

		sendEmail();


		System.out.println("Done");

	}

	public static void main(String[] args) {

		new File(ArticleController.uploadDirectory).mkdir();
		new File(ProviderController.uploadDirectoryProvider).mkdir();

		SpringApplication.run(Workshop2Application.class, args);

	}
}
