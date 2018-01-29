package ru.itpark.component;

import ru.itpark.domain.Movie;

import java.util.function.Consumer;

public interface MovieProvider {
  void forEach(Consumer<? super Movie> consumer);
}
