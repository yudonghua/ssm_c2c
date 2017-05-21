package com.service;

import com.entity.Goods;

import java.util.List;

/**
 * Created by PC on 2017/5/19.
 */
public interface GoodsService {
    public void insertGoods(Goods goods);
    public void deleteGoods(String id);
    public Goods getGoods(String id);
    public void updateGoods(Goods goods);
    public List<Goods> getAllGoods(Goods goods);
    public List<Goods> getMyGoods(String Customer);
}
