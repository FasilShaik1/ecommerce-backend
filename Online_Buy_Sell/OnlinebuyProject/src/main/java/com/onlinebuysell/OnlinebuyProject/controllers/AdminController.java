package com.onlinebuysell.OnlinebuyProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebuysell.OnlinebuyProject.Entity.Admins;
import com.onlinebuysell.OnlinebuyProject.Entity.Product;
import com.onlinebuysell.OnlinebuyProject.service.AdminService;


@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;



	@PostMapping("/register")
	public ResponseEntity<String> registerAdmin(@RequestBody Admins admin) {

		adminService.registerAdmin(admin);
		return ResponseEntity.ok("Admin registered successfully.");
	}

	@PostMapping("/product")
	public ResponseEntity<String> postProduct(@RequestBody Product product) {

		adminService.postProduct(product);
		return ResponseEntity.ok("Product posted successfully.");
	}

	@PutMapping("/product/{productId}")
	public ResponseEntity<String> updateProduct(@PathVariable Long productId, @RequestBody Product product) {

		adminService.updateProduct(productId, product);
		return ResponseEntity.ok("Product updated successfully.");
	}

	@DeleteMapping("/product/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long productId) {

		adminService.deleteProduct(productId);
		return ResponseEntity.ok("Product deleted successfully.");
	}
}
