package com.halalmeatdepot.domain;

import java.io.Serializable;

/**
 * Created by sjchen on 8/31/16.
 */
public class Order implements Serializable {
    private long id;
    private String name;
    private Customer customer;

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
