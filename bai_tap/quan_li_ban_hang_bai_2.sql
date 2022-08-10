drop database if exists quan_ly_ban_hang;
create database quan_ly_ban_hang;
use quan_ly_ban_hang;

create table customer(
c_id int primary key,
c_name varchar(45) not null,
c_age int not null
);

create table `order`(
o_id int primary key,
c_id int,
o_date date not null,
total_price double ,
foreign key (c_id) references customer(c_id)
);

create table product(
p_id int primary key,
p_name varchar(45) not null,
p_price  double not null
);

create table orderdetail (
o_id int,
p_id int,
o_dqty varchar(45),
primary key (o_id,p_id),
foreign key (o_id) references `order`(o_id),
foreign key (p_id) references product(p_id)
);