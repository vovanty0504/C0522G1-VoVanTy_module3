drop database if exists quan_li_san_pham;
create database quan_li_san_pham;
use quan_li_san_pham;

create table nha_cung_cap(
ma_nha_cc int primary key,
ten_nha_cc varchar(50),
dia_chi varchar(50)
);

create table so_dien_thoai(
	sdt varchar(20) primary key,
    ma_nha_cc int,
    foreign key (ma_nha_cc) references nha_cung_cap(ma_nha_cc)
);

create table don_dat_hang(
so_dat_hang int primary key,
ngay_dat_hang date not null,
ma_nha_cc int,
foreign key (ma_nha_cc) references nha_cung_cap(ma_nha_cc)
);

create table vat_tu(
ma_vt int primary key,
ten_vt varchar(45)
);

create table chi_tiet_dat_hang(
so_dat_hang int,
ma_vt int,
primary key(so_dat_hang,ma_vt),
foreign key (so_dat_hang) references don_dat_hang(so_dat_hang),
foreign key (ma_vt) references vat_tu(ma_vt)
);

create table phieu_xuat(
so_px int primary key,
ngay_xuat date not null
);

create table phieu_nhap(
so_pn int primary key,
ngay_nhap date not null
);


create table chi_tiet_phieu_xuat(
don_gia_xuat double,
so_luong_xuat int ,
so_px int,
ma_vt int,
primary key(so_px,ma_vt),
foreign key(so_px) references phieu_xuat(so_px),
foreign key(ma_vt) references vat_tu(ma_vt)
);


create table chi_tiet_phieu_nhap(
don_gia_nhap double not null,
so_luong_nhap int not null,
so_pn int,
ma_vt int,
primary key(so_pn,ma_vt),
foreign key(so_pn) references phieu_nhap(so_pn),
foreign key(ma_vt) references vat_tu(ma_vt)
);
