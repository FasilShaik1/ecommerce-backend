package com.onlinebuysell.OnlinebuyProject.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinebuysell.OnlinebuyProject.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	
    

	List<Product> findByCategory(String category);
}
