package com.zemoga.portfolio.java.web.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"com.zemoga.portfolio.java.*"})
@EnableJpaRepositories("com.zemoga.portfolio.java.*")
@EntityScan("com.zemoga.portfolio.java.*")
@SpringBootApplication
public class WebFrontendApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebFrontendApplication.class, args);
    }
}
