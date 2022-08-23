use casetudy_database;

-- 21.Tạo khung nhìn có tên là v_nhan_vien để lấy được thông tin của tất cả các nhân viên có địa
--  chỉ là “Hải Châu” và đã từng lập hợp đồng 
-- cho một hoặc nhiều khách hàng bất kì với ngày lập hợp đồng là “12/12/2019”. 25/4/2021

create view v_nhan_vien as
select 
nhan_vien.ma_nhan_vien,
nhan_vien.ho_ten,
nhan_vien.dia_chi,
hop_dong.ngay_lam_hop_dong
from nhan_vien
join hop_dong on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
where dia_chi like '%Yên Bái%' and ngay_lam_hop_dong = '2021-04-25'
;
drop view v_nhan_vien;
select * from v_nhan_vien;
select * from nhan_vien;


-- 22.	Thông qua khung nhìn v_nhan_vien thực hiện cập nhật địa chỉ thành
--  “Liên Chiểu” đối với tất cả các nhân viên được nhìn thấy bởi khung nhìn này.
SET SQL_SAFE_UPDATES = 0;
SET SQL_SAFE_UPDATES = 1;
update v_nhan_vien
set dia_chi = 'Liên Chiểu';
select * from nhan_vien
where dia_chi = 'Liên Chiểu';

-- 23.Tạo Stored Procedure sp_xoa_khach_hang dùng để xóa thông tin của
--  một khách hàng nào đó với ma_khach_hang được truyền vào như là 1 tham số của sp_xoa_khach_hang.


delimiter //
create procedure sp_xoa_khach_hang (in p_ma_khach_hang int )
begin
update khach_hang
set khach_hang_bi_xoa = 1
where ma_khach_hang = p_ma_khach_hang ;
end//
delimiter ;

drop procedure sp_xoa_khach_hang;
call sp_xoa_khach_hang(1);

select khach_hang.ma_khach_hang,
khach_hang.ho_ten,
khach_hang.khach_hang_bi_xoa
from khach_hang
where khach_hang_bi_xoa = 1;
--

-- 24.Tạo Stored Procedure sp_them_moi_hop_dong dùng để thêm mới vào bảng hop_dong với yêu cầu sp_them_moi_hop_dong
--  phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, 
-- với nguyên tắc không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.
delimiter //
create procedure sp_them_moi_hop_dong (
p_ma_hop_dong int ,
p_ngay_lam_hop_dong datetime ,
p_ngay_ket_thuc datetime ,
p_tien_dat_coc double ,
p_ma_nhan_vien int,
p_ma_khach_hang int,
p_ma_dich_vu int
)
begin 
insert into hop_dong (
ma_hop_dong ,
ngay_lam_hop_dong  ,
ngay_ket_thuc  ,
tien_dat_coc ,
ma_nhan_vien,
ma_khach_hang ,
ma_dich_vu )
 values
(p_ma_hop_dong  ,
p_ngay_lam_hop_dong  ,
p_ngay_ket_thuc  ,
p_tien_dat_coc  ,
p_ma_nhan_vien ,
p_ma_khach_hang ,
p_ma_dich_vu );
end//
delimiter ;

call sp_them_moi_hop_dong (13,'2021-05-25','2021-05-27',0,7,10,1);
select * from hop_dong;

-- 25.Tạo Trigger có tên tr_xoa_hop_dong khi xóa bản ghi trong bảng hop_dong thì hiển thị tổng số lượng bản ghi còn 
-- lại có trong bảng hop_dong ra giao diện console của database.
-- Lưu ý: Đối với MySQL thì sử dụng SIGNAL hoặc ghi log thay cho việc ghi ở console.

create table `history`(
id int auto_increment primary key ,
ma_hop_dong int,
hop_dong_chua_xoa int ,
hop_dong_da_bi_xoa int,
ngay_xoa date ,
shd_con_lai int);
drop table `history`;
select * 
from  `history`

delimiter //
create trigger tr_xoa_hop_dong 
after update on hop_dong
for each row
begin
declare bien_dem int ;
select count(ma_hop_dong) 
into bien_dem 
from hop_dong
where hop_dong_bi_xoa = 0 ;
insert into `history` 
(ma_hop_dong, hop_dong_chua_xoa, hop_dong_da_bi_xoa, ngay_xoa, shd_con_lai )
values (old.ma_hop_dong,old.hop_dong_bi_xoa, new.hop_dong_bi_xoa, now(), bien_dem);
end //
delimiter ;

drop trigger tr_xoa_hop_dong;

update hop_dong set hop_dong_bi_xoa = 1
where ma_hop_dong = 1 ;


select * from `history`;