CREATE DATABASE demo;
USE demo;

create table users (
 id  int(3) NOT NULL AUTO_INCREMENT,
 name varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);

insert into users (id,name,email,country)
values(1,'võ văn tý','tyvo@gmail.com','viet nam a'),
(2,'võ văn tý','tyvo@gmail.com','hoa ky'),
(3,'võ văn ti','tyvo@gmail.com','viet nam'),
(4,'võ văn ta','tyvo@gmail.com','viet nam'),
(5,'võ văn tl','tyvo@gmail.com','viet nam');


delimiter $$
create procedure display()
begin
select *
from users;
end $$
delimiter ;

call display;

delimiter //
 create procedure update_user(
 p_id int,
 p_name varchar(50),
 p_email varchar(120),
 p_country varchar(120)
)
 begin
 update users
 set
 `name` = p_name,
 email = p_email,
 country = p_country
 where id = p_id;
 end //
 delimiter ;
 
call update_user();


delimiter //
create procedure delete_user(in p_id int)
begin
delete from users where id = p_id;
end //
delimiter ;

call delete_user();

