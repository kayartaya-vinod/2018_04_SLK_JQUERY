drop database if exists mvcapp_db;

create database mvcapp_db;
use mvcapp_db;

create table contacts (
	id int primary key auto_increment,
	name varchar(255) not null,
	email varchar(255) not null,
	phone varchar(255) not null,
	city varchar(255),
	constraint contacts_email_unique unique(email),
	constraint contacts_phone_unique unique(phone)
);

insert into contacts values
(null, 'Vinod', 'vinod@vinod.co', '9731424784', 'Bangalore'),
(null, 'Shyam Sundar', 'shyamkc@gmail.com', '9731424333', 'Bangalore'),
(null, 'John Doe', 'johndoe@example.com', '5551424722', 'Dallas');
