package ru.itpark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itpark.service.ProductsService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/goods")
public class ProductController {

    private final ProductsService productsService;

    @Autowired
    public ProductController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping
    public String getAll(HttpServletRequest request) {
        request.setAttribute("goods", productsService.findAll());
        return "goods";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable int id, HttpServletRequest request) {
        request.setAttribute("product", productsService.findById(id));
        return "product";
    }

    @GetMapping(params = "name")
    public String searchByName(@RequestParam String name, HttpServletRequest request) {
        request.setAttribute("goods", productsService.findByName(name));
        return "goods";
    }
}
