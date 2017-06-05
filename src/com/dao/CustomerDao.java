package com.dao;

/**
 * Created by Dell on 2017/5/19.
 */
import com.entity.Customer;
import org.mybatis.spring.annotation.Mapper;

import java.util.List;
import java.util.Map;

@Mapper("customerDao")
public interface CustomerDao {
    public void insertCustomer(Customer customer);
    public void deleteCustomer(String string);
    public Customer getCustomer(String string);
    public List<Customer> getAllCustomer();
    public void updateCustomer(Customer customer);
}