CREATE DATABASE demo;
USE demo;

create table users (
	id int(3) NOT NULL auto_increment,
    `name` varchar(120) not null,
    email varchar(220) not null,
    country varchar(120),
    primary key(id)
);

insert into users(`name`,email,country)
values('Minh','minh@codegym.vn','Viet Nam');
insert into users(`name`,email,country)
values('Kante','kante@che.uk','Kenia');
insert into users(`name`,email,country)
values('Dat','abc@gmail.com','viet nam');

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
in user_name varchar(50),
in user_email varchar(50),
in user_country varchar(50)
)
begin
	insert into users(`name`,email,country)values(user_name,user_email,user_country);
end $$
DELIMITER ;

