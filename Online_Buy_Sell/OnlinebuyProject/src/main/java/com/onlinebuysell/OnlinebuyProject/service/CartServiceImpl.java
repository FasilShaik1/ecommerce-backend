package com.onlinebuysell.OnlinebuyProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebuysell.OnlinebuyProject.Entity.Cart;
import com.onlinebuysell.OnlinebuyProject.repositary.CartRepository;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public void addItemToCart(Cart cartItem) {
        
        cartRepository.save(cartItem);
    }

    @Override
    public void updateCartItem(Cart cartItem) {
        
        cartRepository.save(cartItem);
    }

    @Override
    public void removeItemFromCart(Long cartItemId) {
        
        cartRepository.deleteById(cartItemId);
    }

    @Override
    public List<Cart> getCartItemsByUserId(Long userId) {
       
        return cartRepository.findByUserId(userId);
    }
}
