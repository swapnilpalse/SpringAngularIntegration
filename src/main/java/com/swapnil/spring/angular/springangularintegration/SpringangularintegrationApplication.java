package com.swapnil.spring.angular.springangularintegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class SpringangularintegrationApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringangularintegrationApplication.class, args);
  }

}

