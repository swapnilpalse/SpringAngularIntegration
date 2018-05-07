package com.swapnil.spring.angular.springangularintegration.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories("com.swapnil.spring.angular.springangularintegration.repositories")
@EnableTransactionManagement

public class DatabaseConfig {

}
