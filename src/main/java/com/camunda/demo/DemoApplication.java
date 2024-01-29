package com.camunda.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.camunda.zeebe.spring.client.EnableZeebeClient;
import io.camunda.zeebe.spring.client.annotation.Deployment;
import io.camunda.zeebe.spring.client.annotation.ZeebeDeployment;

@SpringBootApplication
//@EnableZeebeClient no need in latest versions 
@Deployment(resources = "classpath:demo1.bpmn")
//@Deployment(resources = {"classpath:demo1.bpmn", "classpath:demo2.bpmn"})
public class DemoApplication {

	public static void main(String[] args) {
		
		   System.out.println("Java Version: ............................" + System.getProperty("java.version"));
		SpringApplication.run(DemoApplication.class, args);
	}

}
