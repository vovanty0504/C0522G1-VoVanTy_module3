use c0422g1;

-- Lấy ra thông tin các học viên, và cho biết các học viên đang theo học lớp nào. 
select student.id,student.`name`,student.birthday,student.gender,student.email,student.`point`,student.`account`,class.`name` 
from student 
join class on student.class_id = class.id
order by id;

-- Lấy ra thông tin các học viên, và cho biết các học viên đang theo học lớp nào và cả các bạn đã đăng ký nhưng chưa có lớp học.
select * from student
join jame on student.`account` = jame.`account`
order by student.id;

-- Lấy thông tin của các học viên tên 'Tien' và 'Toan’.
select * from student where `name` like'%Tien'or `name` like '%Toan';

-- Lấy ra học viên có điểm lớn hơn 5 .
select student.id,student.`name`, student.point from student where student.point > 5;

-- Lấy ra học viên có họ là “nguyen”
select * from student where `name` like 'nguyen%';

-- Thông kế số lượng học sinh theo từng loại điểm.
select student.`point`,count(student.id) as so_luong_hoc_sinh 
from student 
group by `point`
order by `point`;

-- Thông kế số lượng học sinh theo điểm và điểm phải lớn hơn 5
select student.`point`,count(student.`point`) as so_luong_hoc_sinh
 from student 
where `point` > 5
group by `point`
order by `point`;

-- Thông kế số lượng học sinh theo điểm lớn hơn 5 và chỉ hiện thị với số lượng>=2
select student.`point`,count(student.`point`) as so_luong_hoc_sinh
 from student 
where `point` > 5
group by `point`
having count(student.`point`)>=2 
order by `point`;

-- Lấy ra danh sách học viên của lớp c1121g1 và sắp xếp tên học viên theo alphabet.
select student.`name`,class.`name` 
from student join class on student.class_id = class.id
where class.id =1
order by class.`name`;