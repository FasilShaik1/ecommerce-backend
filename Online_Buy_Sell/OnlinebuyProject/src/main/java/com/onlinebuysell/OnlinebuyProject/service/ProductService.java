package com.onlinebuysell.OnlinebuyProject.service;

import java.util.List;

import com.onlinebuysell.OnlinebuyProject.Entity.Product;

public interface ProductService {
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    Product getProductById(Long productId);
}
