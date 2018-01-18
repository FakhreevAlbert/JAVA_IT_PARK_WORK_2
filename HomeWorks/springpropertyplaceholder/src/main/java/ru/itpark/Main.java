package ru.itpark;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;
import ru.itpark.bean.Connector;
import ru.itpark.config.Config;

public class Main {
  public static void main(String[] args) {
//      {
//          System.out.println(new ClassPathXmlApplicationContext("beans.xml").getBean(Connector.class).getLogin());
//      }
//      {
//          System.out.println(new GenericGroovyApplicationContext("beans.groovy").getBean(Connector.class).getLogin());
//      }
//      {
//          System.out.println(new AnnotationConfigApplicationContext("ru.itpark.component").getBean(ru.itpark.component.Connector.class).getLogin());
//      }
      {
          System.out.println(new AnnotationConfigApplicationContext(Config.class).getBean(ru.itpark.config.Connector.class).getLogin());
      }
  }
}
