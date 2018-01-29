package ru.itpark.component;

import ru.itpark.domain.Movie;

import java.sql.SQLException;

public interface MovieStorage {
  void save(Movie movie) throws SQLException;
}
