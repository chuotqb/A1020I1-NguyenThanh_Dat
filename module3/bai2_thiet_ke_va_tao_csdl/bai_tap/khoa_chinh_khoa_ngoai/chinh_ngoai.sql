drop database if exists bank;
create database bank;
use bank;

create table customers (
	customer_number int primary key ,
    fullname varchar(50),
    address varchar(50),
    email varchar(50),
    phone varchar(50)
);

create table accounts (
	account_number int primary key,
    account_type varchar(50),
    `date` varchar(50),
    balance int,
    customer_number int,
    foreign key (customer_number) references customers (customer_number)
);

create table transactions (
	tran_number int primary key,
    `date` varchar(50),
    amounts int,
    descriptions varchar(50),
    account_number int,
    foreign key (account_number) references accounts (account_number)
);


