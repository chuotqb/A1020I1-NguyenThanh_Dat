drop database if exists cac_ham;

create database cac_ham;

use cac_ham;

create table hoc_vien (
	id int,
    ten varchar(45),
    tuoi int,
    khoa_hoc varchar(45),
    so_tien int
);

insert into hoc_vien
values
(1,'Hoang',21,'CNTT',400000),
(2,'Viet',19,'DTVT',320000),
(3,'Thanh',18,'KTDN',400000),
(4,'Nhan',19,'CK',450000),
(5,'Huong',20,'TCNH',500000),
(5,'Huong',20,'TCNH',200000);

select *
from hoc_vien
where ten = 'Huong';

select ten, sum(so_tien) as tong_tien
from hoc_vien
where ten = 'Huong';

select distinct ten
from hoc_vien;

select avg(so_tien) as tbc
from hoc_vien