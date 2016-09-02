package com.halalmeatdepot.domain;

/**
 * Created by sjchen on 9/2/16.
 */
public class OrderItem {
    private Long id;
    private Order order;
    private boolean giftwrap;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public boolean isGiftwrap() {
        return giftwrap;
    }

    public void setGiftwrap(boolean giftwrap) {
        this.giftwrap = giftwrap;
    }
}
