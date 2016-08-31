package com.halalmeatdepot.domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by sjchen on 8/31/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/hibernate.xml"})
@Transactional
public class hibernateTest {
    @Autowired
    private SessionFactory sessionFactory;


    @Test
    @Rollback( value = false)
    public void testCreate() {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = new Customer();
        customer.setEmail("siji@gmail.com");
        customer.setRegisterDate(new Date());
        session.save(customer);
        Order order = new Order();
        order.setCustomer(customer);
        session.save(order);
    }
}
