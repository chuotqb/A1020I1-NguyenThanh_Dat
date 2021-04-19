drop database if exists furama;

create database furama;

use furama;

create table kieu_thue (
	id_kieu_thue int primary key,
    ten_kieu_thue varchar(45),
    gia int
);

create table loai_dich_vu (
	id_loai_dich_vu int primary key,
    ten_loai_dich_vu varchar(45)
);

create table vi_tri (
	id_vi_tri int primary key,
    ten_vi_tri varchar(45)
);

create table bo_phan (
	id_bo_phan int primary key,
    ten_bo_phan varchar(45)
);

create table trinh_do (
	id_trinh_do int primary key,
    trinh_do varchar(50)
);

create table loai_khach (
	id_loai_khach int primary key,
    ten_loai_khach varchar(45)
);

create table khach_hang (
	id_khach_hang int primary key,
    id_loai_khach int,
    ho_ten varchar(45),
    ngay_sinh date,
    so_cmnd varchar(45),
    sdt varchar(45),
    email varchar(45),
    dia_chi varchar(45),
    
    foreign key (id_loai_khach) references loai_khach (id_loai_khach)
);

create table nhan_vien (
	id_nhan_vien int primary key,
    ho_ten varchar(45),
    id_vi_tri int,
    id_trinh_do int,
    id_bo_phan int,
    ngay_sinh date,
    so_cmnd varchar(45),
    luong varchar(45),
    sdt varchar(45),
    email varchar(45),
    dia_chi varchar(45),
    
    foreign key (id_vi_tri) references vi_tri (id_vi_tri),
    foreign key (id_bo_phan) references bo_phan (id_bo_phan),
    foreign key (id_trinh_do) references trinh_do (id_trinh_do)
);



create table dich_vu (
	id_dich_vu int primary key,
    ten_dich_vu varchar(45),
    dien_tich int,
    so_tang int,
    so_nguoi_toi_da int,
    chi_phi_thue int,
    id_kieu_thue int,
    id_loai_dich_vu int,
    trang_thai varchar(45),
    
    foreign key (id_kieu_thue) references kieu_thue (id_kieu_thue),
    foreign key (id_loai_dich_vu) references loai_dich_vu (id_loai_dich_vu)
);

create table dich_vu_di_kem (
	id_dich_vu_di_kem int primary key,
    ten_dich_vu_di_kem varchar(45),
    gia int,
    don_vi int,
    trang_thai_kha_dung varchar(45)
);

create table hop_dong (
	id_hop_dong int primary key,
    id_nhan_vien int,
    id_khach_hang int,
    id_dich_vu int,
    ngay_lam_hop_dong date,
    ngay_ket_thuc date,
    tien_dat_coc int,
    tong_tien int,
    
    foreign key (id_nhan_vien) references nhan_vien (id_nhan_vien),
    foreign key (id_khach_hang) references khach_hang (id_khach_hang),
    foreign key (id_dich_vu) references dich_vu (id_dich_vu)
);

create table hop_dong_chi_tiet (
	id_hop_dong_chi_tiet int primary key,
    id_hop_dong int,
    id_dich_vu_di_kem int,
    so_luong int,
    
    foreign key (id_hop_dong) references hop_dong (id_hop_dong),
    foreign key (id_dich_vu_di_kem) references dich_vu_di_kem (id_dich_vu_di_kem)
);

insert into furama.vi_tri
values
(1,'thu ngân'),
(2,'buồng phòng'),
(3,'massage'),
(4,'lái xe'),
(5,'giữ xe');

insert into furama.trinh_do
values
(1,'đại học'),
(2,'cao đẳng'),
(3,'trung cấp'),
(4,'thạc sĩ'),
(5,'tiến sĩ'),
(7,'giáo sư');

insert into furama.bo_phan
values
(1,'kĩ thuật'),
(3,'kế toán'),
(6,'sales'),
(7,'outdoor'),
(10,'indoor'),
(12,'marketing');

insert into furama.nhan_vien
values
(1,'Đạt',1,2,3,'1996-02-28','18549545','1000','0985947544','dat@gmail.com','Quảng Bình'),
(2,'Tiến',2,4,6,'1999-02-20','18565545','800','0985947111','tien@gmail.com','Quảng Trị'),
(3,'Khoa',3,3,7,'1993-10-04','18565545','500','098494561','khoa@gmail.com','Quảng Trị'),
(4,'Hoa',4,7,10,'1983-11-09','18587655','2000','098477771','hoa@gmail.com','Đà Nẵng'),
(5,'Quyết',5,3,12,'1997-03-10','18589995','3000','09899971','quyet@gmail.com','Vũng Tàu');

insert into furama.loai_khach
values
(1,'diamond'),
(2,'platinium'),
(3,'gold'),
(4,'member');

insert into furama.kieu_thue
values
(1,'ngày',1000),
(2,'tháng',3000),
(3,'năm',2000);

insert into furama.loai_dich_vu
values
(1,'family'),
(2,'company'),
(3,'single');

insert into dich_vu_di_kem
values
(1,'massage',1000,1,'open'),
(2,'karaoke',2000,3,'close'),
(3,'drink',3000,2,'close'),
(4,'food',4000,4,'close'),
(5,'car',5000,5,'open');

insert into furama.dich_vu
values
(1,'villa',80,20,40,1000,1,1,'còn phòng'),
(2,'house',70,30,50,2000,2,2,'hết phòng'),
(3,'room',65,20,60,3000,3,3,'hết phòng');

insert into khach_hang
values
(1,1,'Đạt','1996-02-11','19994403','0944334334','dat@gmail.com','Đà Nẵng'),
(2,1,'Nam','1994-01-14','19991203','0943234567','nam@gmail.com','Quảng Ngãi'),
(3,1,'Quang','2003-02-11','11394403','0944334543','quang@gmail.com','Quảng Trị'),
(4,4,'Việt','1950-02-11','11394403','0944334543','viet@gmail.com','Quảng Trị'),
(5,2,'Quang','1950-02-11','11391233','0944334543','quang@gmail.com','Quảng Nam'),
(6,1,'Bình','1951-03-12','11391433','094432355','binh@gmail.com','Vinh');

insert into furama.hop_dong
values
(1,1,1,1,'2019-01-20','2019-02-21',1000,10000),
(2,2,1,2,'2019-09-22','2019-01-23',2000,20000),
(3,3,3,1,'2018-03-24','2018-03-25',3000,30000),
(4,3,2,1,'2018-05-30','2018-05-31',3000,70000),
(5,2,1,2,'2019-02-17','2019-01-18',4000,60000),
(6,3,6,1,'2019-03-12','2019-03-13',5000,50000),
(7,4,6,1,'2019-12-12','2019-12-13',6000,40000),
(8,3,1,2,'2019-03-12','2019-12-13',7000,20000),
(9,4,1,2,'2020-03-12','2020-03-13',3000,50000),
(10,5,5,2,'2019-04-12','2019-04-13',4000,30000),
(11,5,1,2,'2015-05-12','2015-05-13',4000,30000),
(12,5,1,2,'2014-01-16','2014-01-17',8000,15000),
(13,5,1,3,'2018-01-16','2018-01-17',9000,40000),
(14,5,1,2,'2019-01-16','2019-01-17',7000,10000);

insert into furama.hop_dong_chi_tiet
values
(1,1,1,10),
(2,2,2,20),
(3,3,3,30),
(4,4,2,40),
(5,5,1,80),
(6,6,1,110),
(7,7,1,90),
(8,8,1,90);













