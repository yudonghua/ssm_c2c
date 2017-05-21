package com.service;

import com.entity.Order;

import java.util.List;

/**
 * Created by Dell on 2017/5/20.
 */
public interface OrderService {
    public List<Order> getBOrder(String business);
    public List<Order> getCOrder(String customer);
    public void updateOrder(Order order);
    public void insertOrder(Order order);
    public Order getOrder(String id);
}
