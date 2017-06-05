package com.service;

import com.entity.Customer;

import java.util.List;
import java.util.Map;

/**
 * Created by Dell on 2017/5/19.
 */
public interface CustomerService {
    public void insertCustomer(Customer customer);
    public void deleteCustomer(String name);
    public Customer getCustomer(String name);
    public List<Customer> getAllCustomer();
    public void updateCustomer(Customer customer);
}
