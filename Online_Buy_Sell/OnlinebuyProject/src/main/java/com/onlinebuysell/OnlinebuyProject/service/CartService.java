package com.onlinebuysell.OnlinebuyProject.service;

import java.util.List;

import com.onlinebuysell.OnlinebuyProject.Entity.Cart;

public interface CartService {
    void addItemToCart(Cart cartItem);
    void updateCartItem(Cart cartItem);
    void removeItemFromCart(Long cartItemId);
    List<Cart> getCartItemsByUserId(Long userId);
   
}
