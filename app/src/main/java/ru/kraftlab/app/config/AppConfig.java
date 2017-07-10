package ru.kraftlab.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"ru.kraftlab.person", "ru.kraftlab.campaign"})
public class AppConfig {
}
