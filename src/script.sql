drop database if exists test;
create database test;
use test;

drop table if exists customer;
create table customer ( 
	id int(11) primary key auto_increment, 
	name varchar(45), 
	surname varchar(45) );
