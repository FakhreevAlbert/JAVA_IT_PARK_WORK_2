package ru.itpark;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.itpark.config.Config;
import ru.itpark.config.Connector;

@SpringJUnitConfig(classes = Config.class)
public class JavaConfigTest {
    @Autowired
    private ApplicationContext context;

    @Test
    public void testBean(@Value("${connector.login}") String value) {
        Assertions.assertAll(
                () -> Assertions.assertNotNull(context.getBean(Connector.class), "Bean founded"),
                () -> Assertions.assertEquals(value, context.getBean(Connector.class).getLogin(), "Bean value injected")
        );

    }
}

