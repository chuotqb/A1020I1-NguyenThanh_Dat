drop database if exists mat_bang;

create database mat_bang;

use mat_bang;

create table rent (
	rent_id varchar(50) primary key,
    area int,
    rent_status_id int,
    number_of_floor int,
    type_rent_id int,
    cost int,
    start_date date,
    end_date date,

 foreign key (rent_status_id) references rent_status (rent_status_id),
 foreign key (type_rent_id) references type_rent (type_rent_id)

);

create table rent_status (
	rent_status_id int primary key,
    name_status varchar(50)
);

create table type_rent (
	type_rent_id int primary key,
    name_type varchar(50)
);




