use quan_ly_ban_hang;

insert into customer (c_id, c_name, c_age)
values 
(1,'Minh Quan', 10),
(2,'Ngoc Oanh', 20),
(3,'Hong Ha', 50);

insert into `order` ( o_id, c_id, o_date,total_price)
values 
(1,1,'2006/3/21',Null),
(2,2,'2006/3/23',Null),
(3,1,'2006/3/16',Null);

insert into product(p_id, p_name,p_price)
values
(1,'May Giat',3),
(2,'Tu Lanh',5),
(3,'Dieu Hoa',7),
(4,'Quat',1),
(5,'Bep Dien',2);

insert into orderdetail (o_id, p_id ,o_dqty)
values
(1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);

select * from customer;
select * from `order`;
select * from product;
select * from orderdetail;

select customer.c_id, customer.c_name, customer.c_age, product.p_name
from customer
join `order` on customer.c_id = `order`.c_id
join orderdetail on orderdetail.o_id = `order`.o_id
join product on product.p_id = orderdetail.p_id;

select customer.c_name
from customer 
where customer.c_id not in 
(  select customer.c_id
from customer
join `order` on customer.c_id = `order`.c_id
join orderdetail on orderdetail.o_id = `order`.o_id
join product on product.p_id = orderdetail.p_id);

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá
--  bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)

select `order`.o_id, `order`.o_date as dayte_pay ,
sum((ifnull(orderdetail.o_dqty,0)* ifnull(product.p_price,0))) as bill_order
from `order`
join orderdetail on `order`.o_id = orderdetail.o_id
join product on product.p_id = orderdetail.p_id
group by `order`.o_id


