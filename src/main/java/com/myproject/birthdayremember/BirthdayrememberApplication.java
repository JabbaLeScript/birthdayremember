package com.myproject.birthdayremember;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.myproject.birthdayremember")
public class BirthdayrememberApplication {

    public static void main(String[] args) {
        SpringApplication.run(BirthdayrememberApplication.class, args);
    }

}
