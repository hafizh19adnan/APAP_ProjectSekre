package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Tugas1APAPApplication
{

    public static void main (String[] args)
    {
        SpringApplication.run (Tugas1APAPApplication.class, args);
    }
    
    
    @Bean
    public RestTemplate restTemplate() {
     return new RestTemplate();
    }
}

