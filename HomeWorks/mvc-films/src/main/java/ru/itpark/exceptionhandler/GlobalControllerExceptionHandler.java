package ru.itpark.exceptionhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    public String defaultErrorHandler(Exception exception){
        return "error";
    }
}
