package ru.itpark;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;
import ru.itpark.bean.Sample;
import ru.itpark.config.JavaConfig;

import java.util.Locale;

public class Main {
  public static void main(String[] args) {
    Locale.setDefault(new Locale("en", "US"));
    System.out.println(
        new GenericGroovyApplicationContext(
            "beans.groovy"
        )
        .getBean(Sample.class)
        .hello()
    );

    System.out.println(new ClassPathXmlApplicationContext("beans.xml")
    .getBean(Sample.class)
    .hello());

    System.out.println(new AnnotationConfigApplicationContext(JavaConfig.class)
            .getBean(Sample.class)
            .hello()
    );




  }
}
