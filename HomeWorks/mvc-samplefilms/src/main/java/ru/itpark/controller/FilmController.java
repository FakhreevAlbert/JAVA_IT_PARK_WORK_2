package ru.itpark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itpark.service.FilmService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/films")
public class FilmController {

    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public String findAll(HttpServletRequest request){
        request.setAttribute("films", filmService.findAll());
        return "films";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable int id, HttpServletRequest request){
        request.setAttribute("film", filmService.findById(id));
        return "film";
    }

    @GetMapping(params = "name")
    public String findByName(@RequestParam String name, HttpServletRequest request){
        request.setAttribute("films", filmService.findByName(name));
        return "films";
    }
}
