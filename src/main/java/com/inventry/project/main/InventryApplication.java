package com.inventry.project.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.inventry.project.usecase.*;



/*@ComponentScan({"com.inventry.project.usecase"})

//@ComponentScan("com.inventry.main")*/

@SpringBootApplication
@EntityScan("com.inventry.model")
@EnableJpaRepositories("com.inventry.project.model")
@ComponentScan({"com.inventry.project"})
public class InventryApplication implements CommandLineRunner {

	@Autowired
	InitServiceImp initserviceimp;
	
	public static void main(String[] args) {
		SpringApplication.run(InventryApplication.class, args);	
	}

	@Override
	public void run(String... args) throws Exception {
	//		initserviceimp.InitDirection();	
	}
	
	
	

}
