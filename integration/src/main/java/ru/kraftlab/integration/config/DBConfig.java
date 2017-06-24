package ru.kraftlab.integration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by Мария on 09.02.2017.
 */
@Configuration
@ComponentScan({"ru.kraftlab.integration"})
@Profile("dev")
public class DBConfig {
    //todo db properties

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource("jdbc:postgresql://localhost:5432/secawa", "postgres", "admin");
        dataSource.setDriverClassName("org.postgresql.Driver");
        return dataSource;
    }
}
