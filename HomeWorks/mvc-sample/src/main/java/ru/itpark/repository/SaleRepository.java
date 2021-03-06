package ru.itpark.repository;

import ru.itpark.domain.Sale;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface SaleRepository {
    List<Sale> findAll();

    Sale findById(int id);

    List<Sale> findByNameContainingIgnoreCase(String manager);
}
