package ru.kraftlab.integration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import ru.kraftlab.integration.service.ADPersonDataLoader;
import ru.kraftlab.integration.service.impl.mock.ADPersonDataCsvLoader;

import javax.sql.DataSource;

/**
 * Created by Мария on 09.02.2017.
 */
@Configuration
@ComponentScan({"ru.kraftlab.integration"})
@Profile("standalone")
public class StandaloneDBConfig {
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
    public ADPersonDataLoader personDataLoader() {
        return new ADPersonDataCsvLoader();
    }
}