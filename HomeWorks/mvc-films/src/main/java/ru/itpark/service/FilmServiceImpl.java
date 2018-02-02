package ru.itpark.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itpark.domain.Film;
import ru.itpark.repository.FilmRepository;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;
     @Autowired
    public FilmServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public List<Film> findAll(){
         return filmRepository.findAll();
    }

    @Override
    public Film findById(int id){
         return filmRepository.findById(id);
    }

    @Override
    public List<Film> findByName(String name){
         return filmRepository.findByNameContainingIgnoreCase(name);
    }
}
