package com.onlinebuysell.OnlinebuyProject.service;

import com.onlinebuysell.OnlinebuyProject.Entity.Cart;
import com.onlinebuysell.OnlinebuyProject.Entity.Product;
import com.onlinebuysell.OnlinebuyProject.Entity.User;

import java.math.BigInteger;
import java.util.List;



public interface UserService {
    void registerUser(User user);
    User loginUser(String username, String password);
    List<Product> getAllProducts();
    void updateCartItem(long cartItemId, int newQuantity);
    void removeFromCart(Long cartItemId);
//    List<Product> getCart(Long userId);
	String addToCart(Cart cart);
	List<Cart> getCart();
	Product getProductById(Long productId);
	List<Product> getProductsByCategory(String category);
	User getuserdetailsById(Long userId);
	List<BigInteger> getContactNumberByContactId(Long contactid);
	

	
}
