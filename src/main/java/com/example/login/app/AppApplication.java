package com.example.login.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AppApplication implements ApplicationRunner{
	public static Logger log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args){
		SpringApplication.run(AppApplication.class, args);
		log.info("Starting App V1.3");

	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// System.out.println(passwordEncoder.encode("12345"));
		
	}

}
