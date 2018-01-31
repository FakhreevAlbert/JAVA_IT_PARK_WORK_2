package ru.itpark.service;

import ru.itpark.domain.Sale;

import java.util.List;

public interface SaleService {
    List<Sale> findAll();

    Sale findById(int id);

    List<Sale> findByName(String name);
}
