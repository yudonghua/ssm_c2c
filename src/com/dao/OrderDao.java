package com.dao;

import com.entity.Order;
import org.mybatis.spring.annotation.Mapper;

import java.util.List;

/**
 * Created by Dell on 2017/5/20.
 */
@Mapper("orderDao")
public interface OrderDao {
    public List<Order> getBOrder(String business);
    public List<Order> getCOrder(String customer);
    public void updateOrder(Order order);
    public void insertOrder(Order order);
    public Order getOrder(String id);
}
