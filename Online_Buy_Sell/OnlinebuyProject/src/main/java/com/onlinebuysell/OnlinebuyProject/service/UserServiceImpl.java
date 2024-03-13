package com.onlinebuysell.OnlinebuyProject.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinebuysell.OnlinebuyProject.Entity.Cart;
import com.onlinebuysell.OnlinebuyProject.Entity.Product;
import com.onlinebuysell.OnlinebuyProject.Entity.User;
import com.onlinebuysell.OnlinebuyProject.repositary.CartRepository;
import com.onlinebuysell.OnlinebuyProject.repositary.ProductRepository;
import com.onlinebuysell.OnlinebuyProject.repositary.UserRepository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;
    
    

    @Override
    public void registerUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User loginUser(String username, String password) {
        User existingUser = userRepository.findByUsername(username);
        if (existingUser != null && existingUser.getPassword().equals(password)) {
            return existingUser; // Authentication successful
        } else {
            return null; // Authentication failed
        }
    }
    
    @Override
    public User getuserdetailsById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
    


    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }
    
    @Override
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    
    
    
    @Override
    public List<BigInteger> getContactNumberByContactId(Long contactid) {
        return userRepository.findContactNumberByContactId(contactid);
    }
    
    


    @Transactional
    @Override
    public String addToCart(Cart cart) {
    cartRepository.save(cart);
    return "Product added to cart successfully";

	}
    
    
    
    
    


   
    @Transactional
    public void updateCartItem(long cartItemId, int newQuantity) {
        Optional<Cart> cartItemOptional = cartRepository.findById(cartItemId);
        if (cartItemOptional.isPresent()) {
            Cart cartItem = cartItemOptional.get();
            cartItem.setQuantity(newQuantity);
            cartRepository.save(cartItem);
        }
    }
    
    
    @Override
    @Transactional
    public void removeFromCart(Long cartItemId) {
        cartRepository.deleteById(cartItemId);
    }



    @Override
    public List<Cart> getCart() {
    	return cartRepository.findAll();
    }
}
