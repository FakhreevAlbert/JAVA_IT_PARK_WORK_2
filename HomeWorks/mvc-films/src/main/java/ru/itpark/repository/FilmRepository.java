package ru.itpark.repository;

import ru.itpark.domain.Film;

import java.util.List;

public interface FilmRepository {
    List<Film> findAll();

    Film findById(int id);

    List<Film> findByNameContainingIgnoreCase(String name);
}
