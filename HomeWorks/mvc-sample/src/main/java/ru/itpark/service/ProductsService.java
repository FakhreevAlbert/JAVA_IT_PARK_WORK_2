package ru.itpark.service;

import ru.itpark.domain.Product;

import java.util.List;

public interface ProductsService {
    List<Product> findAll();

    Product findById(int id);

    List<Product> findByName(String name);
}
