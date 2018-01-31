package ru.itpark.repository;

import ru.itpark.domain.Product;

import java.util.List;

public interface ProductReposytory {
    List<Product> findAll();

    Product findById(int id);

    List<Product> findByNameContainingIgnoreCase(String name);
}
