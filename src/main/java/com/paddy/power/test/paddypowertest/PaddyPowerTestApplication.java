package com.paddy.power.test.paddypowertest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = {"com.paddy.power.test*"})
@SpringBootApplication
@EnableAutoConfiguration(excludeName = {"org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration"})
public class PaddyPowerTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaddyPowerTestApplication.class, args);
    }

}
