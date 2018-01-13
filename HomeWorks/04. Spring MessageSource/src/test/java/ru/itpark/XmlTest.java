package ru.itpark;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.itpark.bean.Sample;

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class XmlTest {

    @Autowired
    private ApplicationContext applicationContext;


    @Test
    @DisplayName("Test MessageSource")
    public void testMessageSource(@Value("Привет из РФ") String basenames){
         Sample sample = applicationContext.getBean(Sample.class);

        Assertions.assertAll(
                ()->Assertions.assertNotNull(sample, "Bean is not null"),
                ()->Assertions.assertEquals(basenames, sample.hello())
        );
    }

    @Test
    @DirtiesContext
    @DisplayName("Test Dirties Context")
    public void testDirtiesContext(@Value("Привет из РФ") String basenames){

        Sample sample = applicationContext.getBean(Sample.class);

        Assertions.assertAll(
                ()->Assertions.assertNotNull(sample, "Bean is not null"),
                ()->Assertions.assertEquals(basenames, sample.hello())
        );

    }
}
