drop database if exists c2c;
create database c2c CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';
drop table if exists c2c.customer;
drop table if exists c2c.goods;
create table c2c.goods(id varchar(255) primary key,customer varchar(255),name varchar(255),type varchar(255),introduce varchar(255),comment text,price int(11))ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table c2c.customer(username varchar(255) primary key,password varchar(255),address text,phone varchar(255))ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table c2c.orders(id varchar(255) primary key,gid varchar(255),customer varchar(255),address varchar(255),status varchar(255), num int(11))ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into c2c.customer(username,password,address,phone) values ('aaa','aaa','test','test');