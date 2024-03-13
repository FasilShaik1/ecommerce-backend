package com.onlinebuysell.OnlinebuyProject.Entity;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id") // Match the column name in your database
    private User user;

    @ManyToOne
    @JoinColumn(name = "productId", referencedColumnName = "id") // Match the column name in your database
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    public Cart() {
        // Default constructor
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Other constructors, getters, and setters...
}
