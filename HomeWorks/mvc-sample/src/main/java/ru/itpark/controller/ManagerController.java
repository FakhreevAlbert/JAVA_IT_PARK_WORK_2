package ru.itpark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itpark.service.ManagerService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/managers")
public class ManagerController {
    private final ManagerService managerService;

    @Autowired
    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping
    public String getAll(HttpServletRequest request) {
        request.setAttribute("managers", managerService.findAll());
        return "managers";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable int id, HttpServletRequest request) {
        request.setAttribute("manager", managerService.findById(id));
        return "manager";
    }

    @GetMapping(params = "name")
    public String searchByName(@RequestParam String name, HttpServletRequest request) {
        request.setAttribute("managers", managerService.findByName(name));
        return "managers";
    }
}
