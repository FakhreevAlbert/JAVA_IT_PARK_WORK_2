package ru.itpark;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.itpark.bean.Sample;
import ru.itpark.config.JavaConfig;

@SpringJUnitConfig(classes = JavaConfig.class)
public class JavaConfigTest {
    @Autowired
    private ApplicationContext applicationContext;


    @Test
    public void testJavaConfig(@Value("Привет из РФ") String basename){

        Assertions.assertAll(
                ()->Assertions.assertNotNull(applicationContext.getBean(Sample.class), "Bean founded"),
                ()->Assertions.assertEquals(basename, applicationContext.getBean(Sample.class).hello())
        );
    }
}
