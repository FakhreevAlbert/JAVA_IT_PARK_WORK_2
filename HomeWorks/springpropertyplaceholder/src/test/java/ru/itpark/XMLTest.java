package ru.itpark;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.itpark.bean.Connector;

/**
 * Created by worker on 12/21/17.
 */

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:beans.xml")
@SpringJUnitConfig(locations = "classpath:beans.xml")
public class XMLTest {
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    @DisplayName("Placeholder values inserted")
    public void testPlaceholder(@Value("${connector.login}") String login) {
        Connector connector = applicationContext.getBean(Connector.class);

        Assertions.assertAll(
                () -> Assertions.assertNotNull(connector, "Bean is not null"),
                () -> Assertions.assertEquals(login, connector.getLogin())
        );
    }

    @Test
    @DirtiesContext
    @DisplayName("Test Dirties context")
    public void testDirtiesContext(@Value("${connector.login}")String login) {
        Connector connector = applicationContext.getBean(Connector.class);

        Assertions.assertAll(
                () -> Assertions.assertNotNull(connector, "Bean is not null"),
                () -> Assertions.assertEquals(login, connector.getLogin())
        );
    }
}
