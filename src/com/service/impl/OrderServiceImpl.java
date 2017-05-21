package com.service.impl;

import com.dao.OrderDao;
import com.entity.Order;
import com.service.OrderService;

import java.util.List;

/**
 * Created by Dell on 2017/5/20.
 */
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao;
    public List<Order> getBOrder(String business){return orderDao.getBOrder(business);};
    public List<Order> getCOrder(String customer){return orderDao.getCOrder(customer);};
    public void updateOrder(Order order){orderDao.updateOrder(order);};
    public void setOrderDao(OrderDao OrderDao) {this.orderDao = OrderDao;}
    public void insertOrder(Order order){ this.orderDao.insertOrder(order);}
    public Order getOrder(String id){return this.orderDao.getOrder(id);}
}
