package com.halalmeatdepot.web;

import com.halalmeatdepot.domain.Customer;
import com.halalmeatdepot.domain.Order;
import com.halalmeatdepot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sjchen on 9/3/16.
 */
@Controller
@RequestMapping(value="/order")
public class OrderController {
    @Autowired
    OrderService orderService ;

    @RequestMapping(method = RequestMethod.GET)
    public String show(Model model) {

        OrderForm orderForm = new OrderForm();

        Customer customer = new Customer();
        customer.setEmail("siji@gmai.com");
        Order order = new Order();
        order.setCustomer(customer);

        orderForm.setOrder(order);


        model.addAttribute("orderForm", orderForm);

        return "order";
    }

    @RequestMapping(method= RequestMethod.POST)
    public String save(@ModelAttribute("orderForm") OrderForm orderForm) {

       // orderForm.setUpForSave();
        orderService.create(orderForm.getOrder());

        return "order";
    }

}