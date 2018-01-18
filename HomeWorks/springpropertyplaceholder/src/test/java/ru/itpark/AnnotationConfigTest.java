package ru.itpark;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.itpark.component.Connector;

@SpringJUnitConfig(classes = AnnotationConfigTest.AnnotationConfig.class)
public class AnnotationConfigTest {
    @Autowired
    private ApplicationContext context;

    @Test
    public void testBeanCreated() {
        Assertions.assertAll(
                () -> Assertions.assertNotNull(context.getBean(Connector.class), "Bean founded")
        );

    }

    @Configuration
    @ComponentScan("ru.itpark.component")
    public static class AnnotationConfig {
    }
}

