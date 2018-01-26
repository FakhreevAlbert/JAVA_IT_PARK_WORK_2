package ru.itpark;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(JavaConfig.class);



        // TODO: работа с объектами

        context.registerShutdownHook();
        // Destroy bean'ов
        // завершение
    }
}
