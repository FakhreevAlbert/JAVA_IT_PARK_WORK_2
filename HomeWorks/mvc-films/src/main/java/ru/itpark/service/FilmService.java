package ru.itpark.service;

import ru.itpark.domain.Film;

import java.util.List;

public interface FilmService {
    List<Film> findAll();

    Film findById(int id);

    List<Film> findByName(String name);
}
