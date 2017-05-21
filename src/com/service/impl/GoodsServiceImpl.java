package com.service.impl;

import com.dao.GoodsDao;
import com.entity.Goods;
import com.service.GoodsService;

import java.util.List;

/**
 * Created by PC on 2017/5/19.
 */
public class GoodsServiceImpl implements GoodsService{
    private GoodsDao goodsDao;
    public void insertGoods(Goods goods) {goodsDao.insertGoods(goods);}
    public void updateGoods(Goods goods) {goodsDao.updateGoods(goods);}
    public List<Goods> getAllGoods(Goods goods) {return this.goodsDao.getAllGoods(goods);}
    public List<Goods> getMyGoods(String customer) {return this.goodsDao.getMyGoods(customer);}
    public void deleteGoods(String id){this.goodsDao.deleteGoods(id);}
    public Goods getGoods(String id){return this.goodsDao.getGoods(id);}
    public void setGoodsDao(GoodsDao GoodsDao) {this.goodsDao = GoodsDao;}
}
