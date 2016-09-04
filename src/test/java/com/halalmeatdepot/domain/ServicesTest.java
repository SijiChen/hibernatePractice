package com.halalmeatdepot.domain;

import com.halalmeatdepot.service.CustomerServices;
import com.halalmeatdepot.service.OrderService;
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
 * Created by sjchen on 9/3/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/hibernate.xml"})
@Transactional
public class ServicesTest {
    @Autowired
    private CustomerServices customerServices;

    @Test
    @Rollback(value = false)
    public void testCreateNewFromService(){
        Customer customer = createNew();
        customerServices.create(customer);
    }

    private Customer createNew(){
        Customer customer = new Customer();
        customer.setEmail("siji2@gmail.com");
        customer.setRegisterDate(LocalDateTime.now());
        customer.setPhoneNum("123-456-7890");
        Order orderOne = new Order();
        orderOne.setName("order1");
        orderOne.setOrderedTime(LocalDateTime.now());
        orderOne.setCustomer(customer);


        customer.setOrders(new ArrayList<Order>());
        customer.getOrders().add(orderOne);


        OrderItem itemOne = new OrderItem();


        orderOne.getOrderItemList().add(itemOne);

        itemOne.setOrder(orderOne);
        return customer;

    }

}
