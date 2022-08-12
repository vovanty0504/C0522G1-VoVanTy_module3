drop database if exists management_products;
create database management_products;
use management_products;

create table products (
id int,
product_code int,
product_name varchar(50),
product_price double,
product_amount int,
product_description varchar(50),
product_status varchar (50)
);

insert into products (id,product_code,product_name,product_price,product_amount,product_description,product_status)
values 
(1,10,'iphone',10000000,5,'sản phẩm mới đẹp','hết hàng'),
(2,11,'iphone',1000000,5,'sản phẩm mới đẹp','hết hàng'),
(3,12,'iphone',100000,5,'sản phẩm mới đẹp','hết hàng'),
(4,13,'samsung',5000000,10,'sản phẩm mới nhập','đang nhập vào kho'),
(5,14,'apple',3000000,2,'sản phẩm mới đẹp','hàng vẵn còn'),
(6,15,'iphone',100000,7,'sản phẩm mới nhập khẩu','đang sửa chữa');

select * from products;

create unique index i_products on products (product_code);
drop index i_products on products;
explain select * from products where product_code = 12 ;

alter table products add index i_id(id);
alter table products drop index i_id;
explain select * from products where id = 1 ;

create  index i_composite  on products (product_name,product_price);
drop index i_composite on products;
explain select * from products where product_name = 'iphone' and product_price=10000000 ;

create view w_products as
 select products.product_code, 
 products.product_name,
 products.product_price,
 products.product_status
 from products;
 
 SET SQL_SAFE_UPDATES = 0;
update w_products
set product_price = 11000
where product_code = 11;
 
 delete from w_products 
 where product_code = 15;
 
select * from w_products;

delimiter //
create procedure sp_get_products_by_id()
begin 
select * from  products;
end //
delimiter ;



delimiter //
create procedure sp_get_add(
id int,
p_code int,
p_name varchar(50),
p_price double,
p_amount int,
p_description varchar(50),
pt_status varchar (50))
begin 
insert into  products(
id ,
product_code ,
product_name ,
product_price ,
product_amount ,
product_description ,
product_status 
)
values
(id ,
p_code ,
p_name ,
p_price ,
p_amount ,
p_description,
pt_status );
end //
delimiter ;

call sp_get_add (13,21,'iphone',1000000,15,'sản phẩm mới đẹp','hết hàng');
call sp_get_add (13,30,'iphone',500,15,'sản phẩm mới đẹp','hết hàng');

delimiter //
create procedure sp_get_remove_by_id(in p_code  int)
begin 
delete from products 
where product_code =p_code ;
end //
delimiter ;

call sp_get_remove_by_id(11);

delimiter //
create procedure sp_get_update_by_id(
id int,
p_code int,
p_name varchar(50),
p_price double,
p_amount int,
p_description varchar(50),
pt_status varchar (50))
begin 
update  products 
set 
product_code =p_code ,
product_name =p_name,
product_price =p_price,
product_amount =p_amount,
product_description= p_description,
product_status =pt_status;
end //
delimiter ;

