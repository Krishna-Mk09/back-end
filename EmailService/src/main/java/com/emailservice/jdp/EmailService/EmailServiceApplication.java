package com.emailservice.jdp.EmailService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@CrossOrigin
public class EmailServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmailServiceApplication.class, args);
    }
}
