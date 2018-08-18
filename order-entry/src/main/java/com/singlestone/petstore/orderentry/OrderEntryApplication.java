package com.singlestone.petstore.orderentry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableCaching
@EnableJpaRepositories("com.singlestone.petstore.orderentry.repository")
@ComponentScan("com.singlestone.petstore")
@SpringBootApplication
public class OrderEntryApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderEntryApplication.class, args);
    }
}
