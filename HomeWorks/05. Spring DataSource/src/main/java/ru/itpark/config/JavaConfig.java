package ru.itpark.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sqlite.SQLiteDataSource;

@Configuration
public class JavaConfig {

 @Bean
 public SQLiteDataSource getDataSource(){
     SQLiteDataSource dataSource = new SQLiteDataSource();
     dataSource.setUrl("jdbc:sqlite:db.sqlite");
     return dataSource;
 }
}
