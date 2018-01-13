package ru.itpark;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.itpark.bean.Sample;

@SpringJUnitConfig(locations = "classpath:beans.groovy")
public class GroovyTest {

    @Autowired
    private ApplicationContext applicationContext;


    @Test
    @DisplayName("Test groovy")
    public void testMessageSourse(@Value("Привет из РФ") String basename){
        Sample sample = applicationContext.getBean(Sample.class);

        Assertions.assertAll(
                ()->Assertions.assertNotNull(basename, "Dean is noy null"),
                ()->Assertions.assertEquals(basename, sample.hello())
        );
    }
    @Test
    @DirtiesContext
    @DisplayName("Test Dirties Context")
    public void testDirtiesContext(@Value("Привет из РФ") String basename){
        Sample sample = applicationContext.getBean(Sample.class);

        Assertions.assertAll(
                ()->Assertions.assertNotNull(basename, "Bean is not null"),
                ()->Assertions.assertEquals(basename, sample.hello())
        );
    }
}
