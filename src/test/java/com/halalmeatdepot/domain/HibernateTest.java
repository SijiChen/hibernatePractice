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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by sjchen on 8/31/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/hibernate.xml"})
@Transactional
public class HibernateTest {
    @Autowired
    private SessionFactory sessionFactory;

    @Test
    @Rollback(value = false)
    /**
     * test for crate a customer and 2 address(billing&shipping)
     * note: both parent and child have to call set method to set the FK correctly; hibernate will not do it automatically
     */
    public void testCreateCustomer() {
        Session session = sessionFactory.getCurrentSession();
        Address address1 =new Address();
        address1.setCity("aldie");
        address1.setAddress_state(AddressState.VA);
        address1.setAddressType(AddressType.BILLING);
        Address address2 = new Address();
        address2.setCity("Chantilly");
        address2.setAddress_state(AddressState.VA);
        address2.setAddressType(AddressType.SHIPPING);
        Customer customer = new Customer();
        customer.setEmail("siji2@gmail.com");
        customer.setRegisterDate(LocalDateTime.now());
        customer.setAddressSet(new HashSet<Address>());
        customer.getAddressSet().add(address1);
        customer.getAddressSet().add(address2);
        address1.setCustomer(customer);
        address2.setCustomer(customer);
        session.save(customer);
    }

    @Test
    @Rollback(value = false)
    /**
     * test to create order: must create customer first
     */
    public void testCreateOrder() {
        Session session = sessionFactory.getCurrentSession();

        Customer customer = new Customer();
        customer.setEmail("siji2@gmail.com");
        customer.setRegisterDate(LocalDateTime.now());

        Order orderOne = new Order();
        orderOne.setName("order1");
        orderOne.setOrderedTime(LocalDateTime.now());
        orderOne.setCustomer(customer);


        customer.setOrders(new ArrayList<Order>());
        customer.getOrders().add(orderOne);


        OrderItem itemOne = new OrderItem();


        orderOne.setOrderItemSet(new ArrayList<>());
        orderOne.getOrderItemSet().add(itemOne);

        itemOne.setOrder(orderOne);


        session.save(customer);

    }



}
