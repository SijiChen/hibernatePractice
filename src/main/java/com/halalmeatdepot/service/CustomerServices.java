package com.halalmeatdepot.service;

import com.halalmeatdepot.domain.Customer;
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
public class CustomerServices {
    @Autowired
    private SessionFactory sessionFactory;

    public Customer create(Customer customer){
        Session s = sessionFactory.getCurrentSession();
        customer.setRegisterDate(LocalDateTime.now());
        s.save(customer);
        return customer;
    }
}
