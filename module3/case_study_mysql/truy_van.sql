use furama;

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
(1,'villa'),
(2,'room'),
(3,'house');

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
(2,2,'Nam','1994-01-14','19991203','0943234567','nam@gmail.com','Hà Nội'),
(3,1,'Quang','2003-02-11','11394403','0944334543','quang@gmail.com','Quảng Trị'),
(4,4,'Việt','1950-02-11','11394403','0944334543','quang@gmail.com','Quảng Trị');

insert into furama.hop_dong
values
(1,1,1,1,'1999-02-20','1999-02-21',1000,10000),
(2,2,1,2,'1996-01-22','1996-01-23',2000,20000),
(3,3,3,3,'1991-03-24','1991-03-25',3000,30000);

insert into furama.hop_dong_chi_tiet
values
(1,1,1,10),
(2,2,2,20),
(3,3,3,30);



 






