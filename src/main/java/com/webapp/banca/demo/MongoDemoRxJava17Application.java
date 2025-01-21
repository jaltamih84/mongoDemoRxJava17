package com.webapp.banca.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.webapp.banca.demo")
public class MongoDemoRxJava17Application {

    public static void main(String[] args) {

        SpringApplication.run(MongoDemoRxJava17Application.class, args);
    }

}
