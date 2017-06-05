package com.service.impl;

import com.dao.CustomerDao;
import com.entity.Customer;
import com.service.CustomerService;

import java.util.List;
import java.util.Map;

/**
 * Created by Dell on 2017/5/19.
 */
public class CustomerServiceImpl implements CustomerService{
    private CustomerDao customerDao;
    public void insertCustomer(Customer customer) {customerDao.insertCustomer(customer);}


    public List<Customer> getAllCustomer() {return this.customerDao.getAllCustomer();}

    @Override
    public void updateCustomer(Customer customer) {
        customerDao.updateCustomer(customer);
    }


    public void deleteCustomer(String username){this.customerDao.deleteCustomer(username);}
    public Customer getCustomer(String username){return this.customerDao.getCustomer(username);}
    public void setCustomerDao(CustomerDao CustomerDao) {this.customerDao = CustomerDao;}
}
