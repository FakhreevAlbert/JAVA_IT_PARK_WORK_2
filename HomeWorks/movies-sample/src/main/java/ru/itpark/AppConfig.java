package ru.itpark;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("ru.itpark.component") // mixed
@PropertySource("classpath:app.properties")
public class AppConfig {
  @Bean
  public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
    return new PropertySourcesPlaceholderConfigurer();
  }

  @Bean
  public DataSource dataSource(
      @Value("${datasource.url}")
      String url
  ) {
    DriverManagerDataSource driverManagerDataSource =
    new DriverManagerDataSource();

    driverManagerDataSource.setUrl(url);

    return driverManagerDataSource;
  }
}
