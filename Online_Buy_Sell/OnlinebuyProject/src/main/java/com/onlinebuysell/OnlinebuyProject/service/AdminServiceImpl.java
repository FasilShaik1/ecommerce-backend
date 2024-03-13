package com.onlinebuysell.OnlinebuyProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinebuysell.OnlinebuyProject.Entity.Admins;
import com.onlinebuysell.OnlinebuyProject.Entity.Product;
import com.onlinebuysell.OnlinebuyProject.repositary.AdminRepository;
import com.onlinebuysell.OnlinebuyProject.repositary.ProductRepository;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void registerAdmin(Admins admin) {
        
        adminRepository.save(admin);
    }

    @Override
    public void postProduct(Product product) {
        
        productRepository.save(product);
    }


    @Override
    @Transactional
    public void updateProduct(Long productId, Product updatedProduct) {
        
        Product existingProduct = productRepository.findById(productId).orElse(null);
        if (existingProduct != null) {
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setCategory(updatedProduct.getCategory());
            productRepository.save(existingProduct); 
        }
    }
    
    
    
    @Override
    public void deleteProduct(Long productId) {
       
        productRepository.deleteById(productId);
    }

    
}
