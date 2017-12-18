package ru.itpark;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;
import ru.itpark.bean.Connector;
import ru.itpark.config.JavaConfig;

public class Main {
  public static void main(String[] args) {
    {
      GenericGroovyApplicationContext context =
          new GenericGroovyApplicationContext("beans.groovy");
      System.out.println(
          context.getBean(Connector.class).getLogin()
      );
    }
    {
      ClassPathXmlApplicationContext xml = new ClassPathXmlApplicationContext("beans.xml");
      System.out.println(xml.getBean(Connector.class).getLogin());
    }


    {
//      AnnotationConfigApplicationContext javaContext = new AnnotationConfigApplicationContext(JavaConfig.class);
//      System.out.println(javaContext.getBean(Connector.class).getLogin());
  }
  }
}
