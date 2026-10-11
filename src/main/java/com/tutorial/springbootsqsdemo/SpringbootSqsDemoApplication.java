package com.tutorial.springbootsqsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.tutorial.springbootsqsdemo")
public class SpringbootSqsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSqsDemoApplication.class, args);
    }

}
