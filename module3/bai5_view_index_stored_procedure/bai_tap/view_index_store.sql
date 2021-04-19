drop database if exists view_index_store;

create database view_index_store;

use view_index_store;

create table products (
	id int primary key,
    product_code int,
    product_name varchar(45),
    product_price int,
    product_amount int,
    product_description varchar(45),
    product_status varchar(45)
);

insert into products
values
(1,1,"Giày",1000000,10,"Giày Thể Thao", "Like New"),
(2,2,"Dép",2000000,20,"Dép Lào", "Second Hand"),
(3,3,"Áo",3000000,30,"Sơ mi", "New"),
(4,4,"Quần",4000000,40,"Kaki", "Second Hand");

create unique index name_unique on products(product_code);
create index name_composite on products(product_name,product_price);
explain select *
from products
where product_code=3;

-- tạo view
create view view_products
as
select product_code, product_name, product_price,product_status
from products;

-- sửa đổi view
update view_products
set product_amount = 100
where product_code =3;

-- tạo store procedure
delimiter //
create procedure information_product()
begin
	select *
    from products;
end;
// delimiter ;
call information_product();

-- thêm sản phẩm
delimiter //
create procedure sp_add_product (in id int, product_code int, product_name varchar(50), product_price int, product_amount int
	, product_description text, product_status varchar(10))
begin
	insert into products 
    value (id, product_code, product_name, product_price, product_amount, product_description, product_status);
end;
// delimiter ;

call sp_add_product(5, 5, 'Đồng hồ', 1000000, 200, 'Casio', 'Sales');

-- sửa sản phẩm
delimiter //
create procedure sp_edit_product (in id int, product_description text)
begin
	update products 
    set products.product_description = product_description 
    where products.id = id;
end;
// delimiter ;
call sp_edit_product(1, 'Edit');

-- xóa sản phẩm
delimiter //
create procedure sp_delete_product (in id int)
begin
	delete products 
    from products 
    where products.id = id;
end;
// delimiter 
call sp_delete_product(1);
