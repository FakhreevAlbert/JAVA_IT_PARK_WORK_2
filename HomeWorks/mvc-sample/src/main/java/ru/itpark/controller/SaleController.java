package ru.itpark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itpark.service.SaleService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/sales")
public class SaleController {

    private final SaleService saleService;
    @Autowired
    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping
    public String getAll(HttpServletRequest request){

        request.setAttribute("sales", saleService.findAll() );
        return "sales";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable int id, HttpServletRequest request){
        request.setAttribute("sale", saleService.findById(id));
        return "sale";
    }

    @GetMapping(params = "name")
    public String getByName(@RequestParam String name, HttpServletRequest request){
        request.setAttribute("sales", saleService.findByName(name));
        return "sales";
    }





}
