package ru.itpark.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itpark.domain.Product;
import ru.itpark.repository.ProductReposytory;

import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {

    private final ProductReposytory productReposytory;
    @Autowired
    public ProductsServiceImpl(ProductReposytory productReposytory) {
        this.productReposytory = productReposytory;
    }

    @Override
    public List<Product> findAll(){
        return productReposytory.findAll();
    }

    @Override
    public Product findById(int id){
        return productReposytory.findById(id);
    }

    @Override
    public List<Product> findByName(String name){
        return productReposytory.findByNameContainingIgnoreCase(name);
    }
}
