use casetudy_database;
select  ma_nhan_vien, ho_ten 
from nhan_vien
 -- where ho_ten like 'T%' or ho_ten like  'H%' or ho_ten like 'K%' and char_length(ho_ten) <=15;
 where ho_ten regexp '^[HKT]' and char_length(ho_ten) <=15;

select *
from khach_hang
-- where dia_chi regexp '[Đà Nẵng | Quảng Trị]' and ( year(curdate())- year(ngay_sinh) between 18 and 50 );
where (dia_chi like '%Đà Nẵng' or  dia_chi like '%Quảng Trị') and ( year(curdate())- year(ngay_sinh) between 18 and 50 );


select khach_hang.ma_khach_hang, khach_hang.ho_ten, count(hop_dong.ma_khach_hang) as so_lan_dat_phong
from khach_hang 	
join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
where khach_hang.ma_loai_khach = 1
group by ma_khach_hang
order by so_lan_dat_phong;

 SELECT 
    khach_hang.ma_khach_hang,
    khach_hang.ho_ten,
    loai_khach.ten_loai_khach,
    hop_dong.ma_hop_dong,
    dich_vu.ten_dich_vu,
    hop_dong.ngay_lam_hop_dong,
    hop_dong.ngay_ket_thuc,
    (IFNULL(dich_vu.chi_phi_thue, 0) + IFNULL(hop_dong_chi_tiet.so_luong, 0) * IFNULL(dich_vu_di_kem.gia, 0)) AS tong_tien
FROM
    khach_hang
        LEFT JOIN
    loai_khach ON khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
        LEFT JOIN
    hop_dong ON khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
        LEFT JOIN
    dich_vu ON dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
        LEFT JOIN
    hop_dong_chi_tiet ON hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
        LEFT JOIN
    dich_vu_di_kem ON dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
GROUP BY ma_hop_dong
ORDER BY ma_khach_hang , ma_hop_dong DESC;
     






