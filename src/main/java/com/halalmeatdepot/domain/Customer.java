package com.halalmeatdepot.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by sjchen on 8/31/16.
 */
public class Customer implements Serializable{
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNum;
    private LocalDateTime registerDate;
    private Set<Address> addressSet;
    private List<Order> orders=new ArrayList<>();


    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Set<Address> getAddressSet() {
        return addressSet;
    }

    public void setAddressSet(Set<Address> addressSet) {
        this.addressSet = addressSet;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (!email.equals(customer.email)) return false;
        return addressSet != null ? addressSet.equals(customer.addressSet) : customer.addressSet == null;

    }

    @Override
    public int hashCode() {
        int result = email.hashCode();
        result = 31 * result + (addressSet != null ? addressSet.hashCode() : 0);
        return result;
    }
}
