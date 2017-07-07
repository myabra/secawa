package ru.kraftlab.web.servlet;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import ru.kraftlab.app.config.DBConfig;
import ru.kraftlab.app.config.StandaloneDBConfig;
import ru.kraftlab.web.config.SpringWebConfig;

public class WebInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {

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
        return new Class[]{DBConfig.class, StandaloneDBConfig.class};
    }
}