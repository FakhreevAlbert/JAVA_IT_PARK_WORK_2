package ru.itpark.config;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import ru.itpark.bean.Sample;

import java.util.Locale;

@Configuration
public class JavaConfig {




    @Bean
public Sample getSample(){
        Sample sample = new Sample();
        sample.setMessageSource(new MessageSource() {
            @Nullable
            public String getMessage(String s, @Nullable Object[] objects, @Nullable String s1, Locale locale) {
                return getMessage("hello", new Object[]{}, Locale.getDefault());
            }

            public String getMessage(String s, @Nullable Object[] objects, Locale locale) throws NoSuchMessageException {
                return null;
            }

            public String getMessage(MessageSourceResolvable messageSourceResolvable, Locale locale) throws NoSuchMessageException {
                return null;
            }
        });


        return sample;
    }

}




