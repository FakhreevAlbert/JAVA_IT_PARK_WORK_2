package ru.itpark.config;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.lang.Nullable;
import ru.itpark.bean.Sample;

import java.util.Locale;

@Configuration
public class JavaConfig {
    @Bean
    public MessageSource getMessage(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }


    @Bean
    public Sample getSample() {
        Sample sample = new Sample();
        sample.setMessageSource(getMessage());
        return sample;


    }
}




