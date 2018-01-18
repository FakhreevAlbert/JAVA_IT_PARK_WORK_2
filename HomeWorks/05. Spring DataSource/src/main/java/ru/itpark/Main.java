package ru.itpark;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;
import ru.itpark.config.JavaConfig;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
  public static void main(String[] args) {
    {
      GenericGroovyApplicationContext context =
          new GenericGroovyApplicationContext("beans.groovy");
      DataSource dataSource = context.getBean(DataSource.class);

      try (Connection connection = dataSource.getConnection()) {
        try (Statement statement = connection.createStatement()) {
          try (ResultSet rs = statement.executeQuery("SELECT id, name, description FROM films")) {
            while (rs.next()) {
              System.out.println(rs.getInt("id"));
            }
          }
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    {
      ClassPathXmlApplicationContext xml = new ClassPathXmlApplicationContext("beans.xml");
      DataSource dataSourceXml = xml.getBean(DataSource.class);
      try(Connection connection = dataSourceXml.getConnection()){
        try(Statement statement= connection.createStatement()){
          try(ResultSet resultSet = statement.executeQuery("SELECT id, name, description FROM films")){
            while (resultSet.next()){
              System.out.println(resultSet.getInt("id"));
            }
          }
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    AnnotationConfigApplicationContext javaContext = new AnnotationConfigApplicationContext(JavaConfig.class);
    DataSource javaDataSource = javaContext.getBean(DataSource.class);
    try(Connection connection = javaDataSource.getConnection()){
      try(Statement statement = connection.createStatement()){
        try(ResultSet resultSet = statement.executeQuery("SELECT id, name, description FROM films")){
          while (resultSet.next()){
            System.out.println(resultSet.getInt("id"));
          }
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.itpark.component");
      DataSource dataSource = context.getBean(DataSource.class);
      try (Connection connection = dataSource.getConnection()) {
        try (Statement statement = connection.createStatement()) {
          try (ResultSet rs = statement.executeQuery("SELECT * FROM films")) {
            while (rs.next()) {
              System.out.println(rs.getInt("id"));
            }
          }
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }




}
