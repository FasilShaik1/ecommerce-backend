package com.onlinebuysell.OnlinebuyProject.controllers;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebuysell.OnlinebuyProject.Entity.Cart;
import com.onlinebuysell.OnlinebuyProject.Entity.Product;
import com.onlinebuysell.OnlinebuyProject.Entity.User;
import com.onlinebuysell.OnlinebuyProject.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody User user) {
		userService.registerUser(user);
		return ResponseEntity.ok("User registered successfully.");
	}

	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody User user) {
		User existingUser = userService.loginUser(user.getUsername(), user.getPassword());
		if (existingUser != null) {
			return ResponseEntity.ok("Login successful.");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed. Invalid credentials.");
		}
	}

	@GetMapping("/userdetails/{userId}")
	public ResponseEntity<User> getuserdetailsById(@PathVariable Long userId) {
		User user=userService.getuserdetailsById(userId);
		
		if (user != null) {
			return ResponseEntity.ok(user);
		} else {
			return ResponseEntity.notFound().build();
		}
		
		
	}

	
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> products = userService.getAllProducts();
		return ResponseEntity.ok(products);
	}

	@GetMapping("/products/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
		
		Product product = userService.getProductById(productId);

		if (product != null) {
			return ResponseEntity.ok(product);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/products/byCategory/{category}")
	public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String category) {
		List<Product> products = userService.getProductsByCategory(category);
		return ResponseEntity.ok(products);
	}
	
	
	 @GetMapping("/contactnumber/{contactid}")
	    public List<BigInteger> getContactNumberByContactId(@PathVariable Long contactid) {
	        return userService.getContactNumberByContactId(contactid);
	    }


	@PostMapping("/user/cart")
	public ResponseEntity<String> addToCart(@RequestBody Cart cart) {
		String str = userService.addToCart(cart);
		return ResponseEntity.status(HttpStatus.CREATED).body(str);

	}
	@PutMapping("/cart/update/{cartItemId}")
	public ResponseEntity<String> updateCartItem(@PathVariable long cartItemId, @RequestBody Map<String, Integer> requestBody) {
		if (requestBody.containsKey("quantity")) {
			int newQuantity = requestBody.get("quantity");
			userService.updateCartItem(cartItemId, newQuantity);
			return ResponseEntity.ok("Cart item updated successfully.");
		} else {
			return ResponseEntity.badRequest().body("Quantity parameter is missing in the request.");
		}
	}

	@DeleteMapping("/cart/remove/{cartItemId}")
	public ResponseEntity<String> removeFromCart(@PathVariable Long cartItemId) {
		userService.removeFromCart(cartItemId);
		return ResponseEntity.ok("Cart item removed successfully.");
	}

	@GetMapping("/cart/getAll")
	public ResponseEntity<List<Cart>> getCart(){
		List<Cart> cart = userService. getCart();
		return ResponseEntity.ok(cart);
	}
}
