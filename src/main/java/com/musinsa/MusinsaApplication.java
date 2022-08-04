package com.musinsa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MusinsaApplication {

    public static void main(String[] args) {
        String profile = System.getProperty("spring.profiles.active");

        if(profile == null) {
            System.setProperty("spring.profiles.active", "local");
        }

        String logProfile = System.getProperty("app.logback.path");

        if(logProfile == null) {
            System.setProperty("app.logback.path", "local");
        }

        SpringApplication.run(MusinsaApplication.class, args);
    }

}
