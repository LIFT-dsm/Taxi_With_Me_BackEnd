package com.example.texiwithme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class TaxiWithMeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaxiWithMeApplication.class, args);
    }

}
