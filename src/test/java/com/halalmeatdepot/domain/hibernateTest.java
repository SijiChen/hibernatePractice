package com.halalmeatdepot.domain;

import model.Department;
import model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    @Rollback(value = false)
    public void testCreateCustomer() {
        Session session = sessionFactory.getCurrentSession();
        Address address =new Address();
        address.setCity("aldie");
        address.setState("va");

        Customer customer = new Customer();
        customer.setEmail("siji2@gmail.com");
        customer.setRegisterDate(new Date());

        address.setCustomer(customer);
        customer.setAddress(address);

        session.save(customer);
    }
    @Test
    @Rollback(value = false)
    public void testCreateOrder() {
        Session session = sessionFactory.getCurrentSession();
        Order order = new Order();
        session.save(order);
    }
    @Test
    @Rollback(value = false)
    public void testCreate() {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = new Customer();
        customer.setEmail("siji@gmail.com");
        customer.setRegisterDate(new Date());
        session.save(customer);

        Order order1 = new Order();
        Order order2 = new Order();
        order1.setName("order1");
        order2.setName("order2");
        customer.setOrders(new ArrayList<Order>());
        customer.getOrders().add(order1);
        customer.getOrders().add(order2);

        session.save(customer);

    }

    @Test
    @Rollback(value = false)
    public void testEmployee() {
        Session session = sessionFactory.getCurrentSession();
        Department department = new Department();
        department.setDepartmentName("Sales");
        session.save(department);

        Employee emp1 = new Employee("Nina", "Mayers", "111");
        Employee emp2 = new Employee("Tony", "Almeida", "222");

        department.setEmployees(new ArrayList<Employee>());
        department.getEmployees().add(emp1);
        department.getEmployees().add(emp2);

        session.save(department);

    }
}
