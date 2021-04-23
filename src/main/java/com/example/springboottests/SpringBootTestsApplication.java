package com.example.springboottests;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.example.springboottests.repository"})
public class SpringBootTestsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTestsApplication.class, args);
    }

}
