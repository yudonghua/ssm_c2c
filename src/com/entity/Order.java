package com.entity;

/**
 * Created by Dell on 2017/5/20.
 */
public class Order {
    private String id;
    private String gid;
    private String business;
    private String customer;
    private String address;
    private String status;
    private String name;
    private int price;
    private int num;
    public void setId(String id){this.id=id;}
    public void setGid(String gid){this.gid=gid;}
    public void setBusiness(String business){this.business=business;}
    public void setCustomer(String customer){this.customer=customer;}
    public void setAddress(String address){this.address=address;}
    public void setStatus(String status){this.status=status;}
    public void setName(String name){this.name=name;}
    public void setPrice(int price){this.price=price;}
    public void setNum(int num){this.num=num;}
    public String getId(){return this.id;}
    public String getGid(){return this.gid;}
    public String getBusiness(){return this.business;}
    public String getCustomer(){return this.customer;}
    public String getAddress(){return this.address;}
    public String getStatus(){return this.status;}
    public String getName(){return this.name;}
    public int getPrice(){return this.price;}
    public int getNum(){return this.num;}
    public Order(String id,String gid,String business,String customer,String address,String status,String name,int price,int num){
        this.id=id;this.gid=gid;this.business=business;this.customer=customer;this.address=address;this.status=status;this.name=name;this.price=price;this.num=num;
    }
    public Order(){}
    public String toString(){
        return id+" "+gid+" "+business+" "+customer+" "+address+" "+status+" "+name+" "+price+" "+num+" ";
    }
}
