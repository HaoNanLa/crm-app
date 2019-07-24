drop table if exists product;
create table product(
	id int primary key auto_increment,
	name varchar(100) not null,
	price double
);