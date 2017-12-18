package ru.itpark;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;
import ru.itpark.bean.Sample;

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
//    System.out.println(new AnnotationConfigApplicationContext(JavaConfig.class)
//            .getBean(Sample.class)
//            .hello()
//    );
    ApplicationContext ctx = (ApplicationContext) new ClassPathXmlApplicationContext("beans.xml");

    System.out.println(ctx.getMessage("hello", new Object[]{}, Locale.getDefault()));

  }
}
