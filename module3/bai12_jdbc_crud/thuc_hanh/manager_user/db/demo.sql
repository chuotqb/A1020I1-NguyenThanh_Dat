CREATE DATABASE 'demo';
USE demo;

create table users (
	id int(3) NOT NULL auto_increment,
    name varchar(120) not null,
    email varchar(220) not null,
    country varchar(120),
    primary key(id)
);

insert into users(name,email,country)
values('Minh','minh@codegym.vn','Viet Nam');
insert into users(name,email.country)
values('Kante','kante@che.uk','Kenia');
