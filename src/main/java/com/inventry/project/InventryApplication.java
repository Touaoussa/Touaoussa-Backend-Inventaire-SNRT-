package com.inventry.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import com.inventry.project.usecase.*;



/*@ComponentScan({"com.inventry.project"})*/


@EnableAutoConfiguration
@SpringBootApplication

public class InventryApplication extends SpringBootServletInitializer {

	/*@Autowired
	InitServiceImp initserviceimp;*/
	
	public static void main(String[] args) {
		SpringApplication.run(InventryApplication.class, args);	
	}


	
	
	

}
