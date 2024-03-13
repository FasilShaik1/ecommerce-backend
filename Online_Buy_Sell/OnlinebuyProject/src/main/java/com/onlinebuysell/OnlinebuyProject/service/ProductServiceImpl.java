package com.onlinebuysell.OnlinebuyProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebuysell.OnlinebuyProject.Entity.Product;
import com.onlinebuysell.OnlinebuyProject.repositary.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
      
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        
        return productRepository.findByCategory(category);
    }

    @Override
    public Product getProductById(Long productId) {
       
        return productRepository.findById(productId).orElse(null);
    }

   
}
