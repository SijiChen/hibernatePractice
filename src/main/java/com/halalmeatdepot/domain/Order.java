package com.halalmeatdepot.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by sjchen on 8/31/16.
 */
public class Order implements Serializable {
    private long id;
    private String name;
    private Customer customer;
    private LocalDateTime orderedTime;
    private Set<OrderItem> orderItemSet;
    public LocalDateTime getOrderedTime() {
        return orderedTime;
    }

    public Set<OrderItem> getOrderItemSet() {
        return orderItemSet;
    }

    public void setOrderItemSet(Set<OrderItem> orderItemSet) {
        this.orderItemSet = orderItemSet;
    }

    public void setOrderedTime(LocalDateTime orderedTime) {
        this.orderedTime = orderedTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
