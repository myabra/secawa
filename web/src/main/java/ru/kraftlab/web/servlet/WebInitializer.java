package ru.kraftlab.web.servlet;

import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import ru.kraftlab.app.config.AppConfig;
import ru.kraftlab.app.config.DBConfig;
import ru.kraftlab.app.config.StandaloneDBConfig;
import ru.kraftlab.web.config.SpringWebConfig;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    private static final String EMBEDDED_DB_PROFILE = "standalone";

    @Override
    protected WebApplicationContext createRootApplicationContext() {
        WebApplicationContext rootContext = super.createRootApplicationContext();
        ((ConfigurableEnvironment) rootContext.getEnvironment()).setDefaultProfiles(EMBEDDED_DB_PROFILE);
        return rootContext;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringWebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConfig.class, DBConfig.class, StandaloneDBConfig.class};
    }
}