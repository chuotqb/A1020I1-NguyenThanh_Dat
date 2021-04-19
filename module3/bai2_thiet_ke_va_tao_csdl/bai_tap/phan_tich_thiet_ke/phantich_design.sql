drop database if exists shop;
create database shop;
use shop;

create table products_line (
	product_line int primary key,
    descripton varchar(50)
);

create table offices (
	office_code int primary key,
    address varchar(50),
    phone varchar(50),
    country varchar(50)
);

create table employees (
	employee_number int primary key,
    employee_name varchar(50),
    email varchar(50),
    job_name varchar(50),
    office_code int,
    foreign key (office_code) references offices (office_code),
    report_to int,
    foreign key (report_to) references employees (employee_number)
);

create table customers (
	customer_number int primary key,
    name_customer varchar(50),
    phone varchar(50),
    address varchar(50),
    employee_number int,
    foreign key (employee_number) references employees (employee_number)
);

create table products (
	product_code int primary key,
    product_name varchar(50),
    product_sponsor varchar(50),
    order_number int,
    cost int,
    product_line int,
    foreign key (product_line) references products_line (product_line)
);

create table orders(
	order_number int primary key,
    day_buy varchar(50),
    day_transfer varchar(50),
    day_tran_actual varchar(50),
    order_range int,
    cost int,
    customer_number int,
    foreign key (customer_number) references customers (customer_number)
);

create table payments(
	code_pay int primary key,
    day_pay varchar(50),
    money int,
    customer_number int,
    foreign key (customer_number) references customers (customer_number)
);



create table product_have_order (
	product_code int,
    order_number int,
    
    primary key (product_code, order_number),
    foreign key (product_code) references products (product_code),
    foreign key (order_number) references orders (order_number) 
);











