package ru.itpark.bean;

import org.springframework.context.MessageSource;

import java.util.Locale;

public class Sample {
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
