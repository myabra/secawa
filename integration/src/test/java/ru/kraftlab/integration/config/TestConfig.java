package ru.kraftlab.integration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import ru.kraftlab.integration.dao.ADPersonDao;
import ru.kraftlab.integration.dao.impl.ADPersonDaoImpl;

import javax.sql.DataSource;

@Configuration
public class TestConfig {
    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = builder
                .setType(EmbeddedDatabaseType.H2)
                .addScript("db/sql/create-db-h2.sql")
                .build();
        return db;
    }

    @Bean
    public ADPersonDao personDao() {
        return new ADPersonDaoImpl(dataSource());
    }
}