drop database if exists libary;

create database libary;

use libary;

create table sach (
	ma_sach int primary key,
    ten_sach varchar(45),
    nha_xuat_ban varchar(45),
    tac_gia varchar(45),
    nam_xuat_ban date,
    so_lan_xuat_ban int,
    gia int,
    anh varchar(45)
);

insert into sach 
values
(1,'người đua diều','nhã nam','khaled hosseini','1993-10-10', 3,1000,'jpg'),
(2,'doraemon','japan','Hiroshi Fujimoto','1983-05-10', 7,2000,'png'),
(3,'connan','hugo','Aoyama Gosho','1993-04-11', 3,3000,'raw'),
(4,'naruto','phương nam','Aoyama Gosho','1990-02-14', 4,5000,'raw'),
(5,'onepiece','fahasha','Aoyama ','1994-05-10', 3,1500,'jpeg');

create table sinh_vien (
	ma_sinh_vien int primary key,
    ten_sinh_vien varchar(45),
    ngay_sinh date,
    dia_chi varchar(45),
    email varchar(45),
    so_dien_thoai varchar(45),
    anh varchar(50)
);

insert into sinh_vien
values
(1,'Đạt', '1995-10-20','Quảng Bình', 'dat@gmail.com', '095544343', 'png'),
(2,'Tuấn', '1991-07-12', 'Quảng Nam','tuan@gmail.com', '095544342', 'raw'),
(3,'Nam', '1992-02-10', 'Quảng Ngãi', 'nam@gmail.com', '095544111', 'jpeg'),
(4,'Liên', '1989-05-01', 'Hồ Chí Minh', 'lien@gmail.com', '095544333', 'png'),
(5,'Toàn', '1989-05-01','Bà Rịa Vũng Tàu', 'toan@gmail.com', '095544333', 'png');

create table loai_sach (
	ma_sach int,
    loai_sach varchar(45),
    foreign key (ma_sach) references sach(ma_sach)
);

insert into loai_sach
values
(1,'Kỹ năng'),
(2,'Ngoại ngữ'),
(3,'Thông dịch'),
(4,'Truyện tranh'),
(5,'Tự truyện');

create table phieu_muon (
	ma_sinh_vien int,
    ma_sach int,
    ngay_muon date,
    ngay_tra date,
    so_luong_muon int,
    trinh_trang_sach text,
    
    primary key(ma_sach,ma_sinh_vien),
    foreign key(ma_sach) references sach(ma_sach),
    foreign key(ma_sinh_vien) references sinh_vien(ma_sinh_vien)

);

insert into phieu_muon
values
(1,1,'2021-04-06','2021-04-07',1,'mới'),
(2,2,'2021-04-03','2021-04-07',2,'mới'),
(3,3,'2021-04-05','2021-04-07',3,'mới'),
(4,4,'2021-04-01','2021-04-07',4,'mới'),
(5,5,'2021-04-02','2021-04-07',5,'mới');


