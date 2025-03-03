package com.revature.ecomproject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_item_id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="order_id")
    private Order order;

    // Need a product class to implement this
//    @ManyToMany(fetch=FetchType.LAZY)
//    @JoinColumn(name="id")
//    private Product product;

    private int quantity;

    private double cost;

}
