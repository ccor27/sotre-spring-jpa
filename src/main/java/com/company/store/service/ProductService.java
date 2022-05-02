package com.company.store.service;

import com.company.store.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductService productService;

    public List<Product> findAll(){
        return productService.findAll();
    }

    public Product findById(Long id){
        return productService.findById(id);
    }

    public Product save(Product product){
        return productService.save(product);
    }

    public void delete(Product product){
        productService.delete(product);
    }
}
