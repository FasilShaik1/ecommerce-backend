package com.onlinebuysell.OnlinebuyProject.service;

import com.onlinebuysell.OnlinebuyProject.Entity.Admins;
import com.onlinebuysell.OnlinebuyProject.Entity.Product;

public interface AdminService {
    void registerAdmin(Admins admin);
    void postProduct(Product product);
    void updateProduct(Long productId, Product product);
    void deleteProduct(Long productId);
    
}
