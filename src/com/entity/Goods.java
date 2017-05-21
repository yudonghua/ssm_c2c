package com.entity;

/**
 * Created by PC on 2017/5/19.
 */
public class Goods {
    private String id;
    private String customer;
    private String name;
    private String type;
    private String introduce;
    private String comment;
    private int price;
    public void setId(String id){this.id=id;}
    public void setCustomer(String customer){this.customer=customer;}
    public void setName(String name){this.name=name;}
    public void setType(String type){this.type=type;}
    public void setIntroduce(String introduce){this.introduce=introduce;}
    public void setComment(String comment){this.comment=comment;}
    public void setPrice(int price){this.price=price;}
    public String getId(){return this.id;}
    public String getCustomer(){return this.customer;}
    public String getName(){return this.name;}
    public String getType(){return this.type;}
    public String getIntroduce(){return this.introduce;}
    public String getComment(){return this.comment;}
    public int getPrice(){return this.price;}
    public Goods(String id,String customer,String name,String type,String introduce ,String comment,int price){this.id=id;this.customer=customer;this.name=name;this.type=type;this.introduce=introduce;this.comment=comment;this.price=price;}
    public Goods(){}
//    public String toString(){return this.name;}
}
