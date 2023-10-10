package com.akashprojects.springbootcore;

import com.akashprojects.springbootcore.ex1.controller.SampleController;
import com.akashprojects.springbootcore.ex2.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootcoreApplication implements CommandLineRunner {

	@Autowired
	private ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootcoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		SampleBean sampleBean = applicationContext.getBean(SampleBean.class);
		sampleBean.getInfo();
		 */

		/*
		SampleController controller = applicationContext.getBean(SampleController.class);
		controller.getControllerInfo();
		 */

		UserController userController = applicationContext.getBean(UserController.class);
		userController.loadUserData();
	}
}
