package com.omi.clientservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class ClientServiceApplication {

	private static final Logger log = (Logger) LoggerFactory.getLogger(ClientServiceApplication.class);


	@LoadBalanced
	@Bean
	public RestTemplate getTemplate(){
		log.info("ClientServiceApplication => getTemplate  :");
		return new RestTemplate();
	}
	public static void main(String[] args) {
		log.info("ClientServiceApplication => main  : ");
		SpringApplication.run(ClientServiceApplication.class, args);
	}

}
