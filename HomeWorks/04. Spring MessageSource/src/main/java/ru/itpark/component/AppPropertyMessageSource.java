package ru.itpark.component;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Locale;
import java.util.ResourceBundle;

@Component

public class AppPropertyMessageSource {
    private MessageSource messageSource;

    public MessageSource getMessageSource() {
        return messageSource;
    }

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    public String hello() {
        return messageSource.getMessage("hello", new Object[]{}, Locale.getDefault());

    }
}

