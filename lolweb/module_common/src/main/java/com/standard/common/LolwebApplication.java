package com.standard.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.standard.common", "com.standard.lolweb"})
public class LolwebApplication {
	public static void main(String[] args) {
		SpringApplication.run(LolwebApplication.class, args);
	}

}
