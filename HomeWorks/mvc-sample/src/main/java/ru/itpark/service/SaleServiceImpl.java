package ru.itpark.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itpark.domain.Sale;
import ru.itpark.repository.SaleRepository;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;


    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public List<Sale> findAll() {
        return saleRepository.findAll();
    }

    @Override
    public Sale findById(int id) {
        return saleRepository.findById(id);
    }

    @Override
    public List<Sale> findByName(String manager) {
        return saleRepository.findByNameContainingIgnoreCase(manager);
    }
}
