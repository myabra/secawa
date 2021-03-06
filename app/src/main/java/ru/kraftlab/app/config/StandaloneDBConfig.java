package ru.kraftlab.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import ru.kraftlab.person.service.ADPersonDataLoader;
import ru.kraftlab.person.service.impl.mock.ADPersonDataCsvLoader;

import javax.sql.DataSource;

@Configuration
@Profile("standalone")
public class StandaloneDBConfig {
    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder
                .setType(EmbeddedDatabaseType.H2)
                .addScript("db/sql/create-db-h2.sql")
                .build();
    }

    @Bean
    public ADPersonDataLoader personDataLoader() {
        return new ADPersonDataCsvLoader();
    }
}