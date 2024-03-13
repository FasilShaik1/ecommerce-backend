package com.onlinebuysell.OnlinebuyProject.repositary;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinebuysell.OnlinebuyProject.Entity.Cart;
import com.onlinebuysell.OnlinebuyProject.Entity.Product;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

	List<Cart> findByUserId(Long userId);

	Cart findByProductId(Long productId);
   List<Product> findProductsInCartByUserId(Long userId);
}
