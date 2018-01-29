package ru.itpark.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class MoviesImporterImpl implements MoviesImporter {
  private MovieProvider provider;
  private MovieStorage storage;

  @Autowired
  public MoviesImporterImpl(MovieProvider provider, MovieStorage storage) {
    this.provider = provider;
    this.storage = storage;
  }

  public Result run() {
    Result result = new Result();
    provider.forEach(movie -> {
      result.incProcessed();
      if (movie != null) {
        try {
          storage.save(movie);
          result.incSucceed();
        } catch (SQLException e) {
          result.incFailed();
          e.printStackTrace();
        }
      } else {
        result.incFailed();
      }
    });

    return result;
  }
}
