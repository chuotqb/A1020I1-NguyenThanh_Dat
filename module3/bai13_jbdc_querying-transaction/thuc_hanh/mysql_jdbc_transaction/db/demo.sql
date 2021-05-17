CREATE DATABASE demo;
USE demo;
create table Permision (
	id int(11) primary key auto_increment,
    `name` varchar(50)
);

create table users (
	id int(11) primary key ,
    `name` varchar(50) not null,
    email varchar(50) not null,
    country varchar(50)
);

insert into users(id,`name`,email,country)
values(3,'Minh','minh@codegym.vn','Viet Nam');
insert into users(id,`name`,email,country)
values(5,'Kante','kante@che.uk','Kenia');
insert into users(id,`name`,email,country)
values(7,'Dat','abc@gmail.com','viet nam');

create table User_Permision(
	permision_id int(11),
    user_id int(11),
    primary key (permision_id,user_id),
    foreign key (permision_id) references Permision (id),
    foreign key (user_id) references users (id)
);

insert into Permision(`name`) values ('add');
insert into Permision(`name`) values ('edit');
insert into Permision(`name`) values ('delete');
insert into Permision(`name`) values ('view');



DELIMITER $$
create procedure get_user_by_id(IN user_id int)
begin
select users.`name`,users.email,users.country
from users
where users.id = user_id;
end $$
DELIMITER ;

DELIMITER $$
create procedure insert_user (
in user_id int,
in user_name varchar(50),
in user_email varchar(50),
in user_country varchar(50)
)
begin
	insert into users(id,`name`,email,country)values(user_id,user_name,user_email,user_country);
end $$
DELIMITER ;











