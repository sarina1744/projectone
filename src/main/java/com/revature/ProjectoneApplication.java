package com.revature;

import com.revature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.net.UnknownServiceException;

@SpringBootApplication
@EnableAspectJAutoProxy
public class ProjectoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectoneApplication.class, args);
	}

	@Autowired
	User user;
}
