package com.fql.orderapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = {})
public class OrderAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderAppApplication.class, args);
    }

}
