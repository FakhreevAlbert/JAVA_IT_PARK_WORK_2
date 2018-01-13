package ru.itpark.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import ru.itpark.bean.Connector;

@Configuration
public class JavaConfig {


    @Bean
    public static PropertyPlaceholderConfigurer getProperty(){
        PropertyPlaceholderConfigurer property = new PropertyPlaceholderConfigurer();
        property.setLocation(new ClassPathResource("connector.properties") {
        });




        return property;
    }

    @Bean
    public Connector getConnector(){
        Connector connector = new Connector();
        connector.setLogin("${connector.login}");
        connector.setPassword("${connector.password}");
        return connector;
    }


}
