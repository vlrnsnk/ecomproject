package com.revature.ecomproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

import java.sql.Time;


/*This class defines our order table in the database
* Foreign key to the user who made the order
* cost of order
* shipping address
* status of order
* */

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "user.id")
    private User user;

    //Total cost of the order
    private double cost;

    //address for shipping
    private String address;

    @Pattern(regexp = "^(PENDING|PROCESSING|SHIPPED|DELIVERED|CANCELLED)$",
        message="status must be one of PENDING, PROCESSING, SHIPPED, DELIVERED, or CANCELLED")
    private String status;

    @CreationTimestamp
    private Time createdAt;

    @UpdateTimestamp
    private Time updatedAt;

    // BOILERPLATE
    public Order() {
    }

    public Order(int order_id, User user, double cost, String address, String status, Time createdAt, Time updatedAt) {
        this.order_id = order_id;
        this.user = user;
        this.cost = cost;
        this.address = address;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Time getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Time createdAt) {
        this.createdAt = createdAt;
    }

    public Time getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Time updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Order{" +
            "order_id=" + order_id +
            ", user=" + user +
            ", cost=" + cost +
            ", address='" + address + '\'' +
            ", status='" + status + '\'' +
            ", createdAt=" + createdAt +
            ", updatedAt=" + updatedAt +
            '}';
    }
}
