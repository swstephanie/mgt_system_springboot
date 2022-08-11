package com.example.demo.config;

import com.example.demo.pojo.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Cat getCat(){
        return new Cat("Tom",12);
    }


}
