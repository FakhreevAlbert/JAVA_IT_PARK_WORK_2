package ru.itpark.component;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.itpark.domain.Movie;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class MovieStorageSQLiteImpl implements MovieStorage, InitializingBean, DisposableBean {
  private DataSource dataSource;
  private Connection connection;

  @Autowired
  public MovieStorageSQLiteImpl(DataSource dataSource) {
    this.dataSource = dataSource;
  }


  @Override
  // TODO: прочитать самсотоятельно
  public void afterPropertiesSet() throws SQLException {
    connection = dataSource.getConnection();
    try (Statement stmt = connection.createStatement()) {
      stmt.execute("DROP TABLE IF EXISTS movies;");
      stmt.execute("CREATE TABLE IF NOT EXISTS movies ( id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT NOT NULL);");
    }
  }


  @Override
  // TODO: прочитать самостоятельно
  public void destroy() throws SQLException {
    connection.close();
  }

  @Override
  public void save(Movie movie) throws SQLException {
    try (PreparedStatement statement = connection.prepareStatement("INSERT INTO movies ('id', 'title') VALUES (?, ?);")) {
      statement.setInt(1, movie.getId());
      statement.setString(2, movie.getTitle());
      statement.execute();
    }
  }
}
