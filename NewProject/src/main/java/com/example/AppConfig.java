package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    public Address address() {
        return new Address("123 Main St", "Springfield");
    }

    @Bean
    @Scope("prototype")
    public Person person() {
        return new Person();
    }
}
