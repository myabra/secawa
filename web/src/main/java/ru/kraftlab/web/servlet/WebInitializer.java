package ru.kraftlab.web.servlet;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import ru.kraftlab.integration.config.SpringIntegrationConfig;
import ru.kraftlab.report.config.SpringReportConfig;
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
        return new Class[]{SpringIntegrationConfig.class, SpringReportConfig.class};
    }

}