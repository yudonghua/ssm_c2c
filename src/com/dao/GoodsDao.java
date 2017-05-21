package com.dao;

import com.entity.Goods;
import org.mybatis.spring.annotation.Mapper;

import java.util.List;

/**
 * Created by PC on 2017/5/19.
 */
@Mapper("goodsDao")
public interface GoodsDao {
    public void insertGoods(Goods goods);
    public void deleteGoods(String id);
    public void updateGoods(Goods goods);
    public Goods getGoods(String id);
    public List<Goods> getAllGoods();
    public List<Goods> getMyGoods(String customer);
}
