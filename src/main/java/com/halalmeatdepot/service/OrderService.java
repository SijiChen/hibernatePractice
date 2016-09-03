package com.halalmeatdepot.service;

import com.halalmeatdepot.domain.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * Created by sjchen on 9/3/16.
 */
@Component
@Transactional
public class OrderService {

    @Autowired
    private SessionFactory sessionFactory;
    public Order create(Order order){
        Session s = sessionFactory.getCurrentSession();
        order.setOrderedTime(LocalDateTime.now());
        s.save(order);
        return order;
    }
}
