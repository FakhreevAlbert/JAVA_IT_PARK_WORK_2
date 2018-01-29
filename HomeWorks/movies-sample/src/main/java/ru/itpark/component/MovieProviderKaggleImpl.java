package ru.itpark.component;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.itpark.domain.Movie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.function.Consumer;

@Component
public class MovieProviderKaggleImpl implements MovieProvider {
  private String moviesCsv;
  private String keywordsCsv;

  @Value("${kaggle.movies.csv}")
  public void setMoviesCsv(String moviesCsv) {
    this.moviesCsv = moviesCsv;
  }

  @Value("${kaggle.keywords.csv}") // надо писать именно над setter'ом
  public void setKeywordsCsv(String keywordsCsv) {
    this.keywordsCsv = keywordsCsv;
  }

  @Override
  public void forEach(Consumer<? super Movie> consumer) {
    try {
      CSVParser parser = CSVFormat
          .RFC4180
          .withHeader()
          .withSkipHeaderRecord(true)
          .parse(
              Files.newBufferedReader(
                  Paths.get(moviesCsv)
              )
          );

      parser.forEach(record -> {
        Movie movie = null;
        try {
          movie = MovieExtractor.extract(record);
        } catch (Exception e) {
          e.printStackTrace();
        }
        consumer.accept(movie);
      });
    } catch (IOException e) {
      // TODO: retrow
      e.printStackTrace();
    }
  }

  static class MovieExtractor {
    public static Movie extract(CSVRecord record) {
      Map<String, String> map = record.toMap();

      int id = Integer.parseInt(map.get("id"), 10);
      String title = map.get("title");
      int budget = Integer.parseInt(map.get("budget"), 10);
      String overview = map.get("overview");

      return new Movie(
          id, title, budget, overview
      );
    }
  }
}
