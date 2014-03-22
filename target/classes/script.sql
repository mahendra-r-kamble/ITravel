drop database if exists test;
create database test;

drop table if exists customer;
create table customer ( 
id int(11) primary key auto_incrememt not null, 
name varchar(45) not null, 
surname varchar(45) not null 
);
