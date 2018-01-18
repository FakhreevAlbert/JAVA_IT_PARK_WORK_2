package ru.itpark.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

/**
 * Created by worker on 12/17/17.
 */
@Configuration
public class Config {
    @Bean
public Connector connector() {
    Connector connector = new Connector();
    return connector;
}

    @Bean
    public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer placeholderConfigurer = new PropertyPlaceholderConfigurer();
        placeholderConfigurer.setLocation(new FileSystemResource("connector.properties"));
        return placeholderConfigurer;
    }
}
