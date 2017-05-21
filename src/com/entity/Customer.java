package com.entity;

/**
 * Created by Dell on 2017/5/19.
 */
public class Customer {
    private String username;
    private String password;
    private String address;
    private String phone;
    public void setUsername(String username){this.username=username;}
    public void setPassword(String password){this.password=password;}
    public void setAddress(String address){this.address=address;}
    public void setPhone(String phone){this.phone=phone;}
    public String getUsername(){return this.username;}
    public String getPassword(){return this.password;}
    public String getAddress(){return this.address;}
    public String getPhone(){return this.phone;}
    public Customer(String username,String password,String address,String phone){this.username=username;this.password=password;this.address=address;this.phone=phone;}
    public Customer(){}
    public String toString(){ return username;}
}
