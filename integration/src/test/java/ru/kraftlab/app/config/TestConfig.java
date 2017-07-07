package ru.kraftlab.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import ru.kraftlab.app.dao.ADPersonDao;
import ru.kraftlab.app.dao.CampaignDAO;
import ru.kraftlab.app.dao.impl.ADPersonDaoImpl;
import ru.kraftlab.app.dao.impl.CampaignDAOImpl;

import javax.sql.DataSource;

@Configuration
public class TestConfig {
    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder
                .setType(EmbeddedDatabaseType.H2)
                .addScript("db/sql/create-db-h2.sql")
                .build();
    }

    @Bean
    public ADPersonDao personDao() {
        return new ADPersonDaoImpl(dataSource());
    }

    @Bean
    public CampaignDAO campaignDAO() {
        return new CampaignDAOImpl(dataSource());
    }
}