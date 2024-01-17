create database studentStackDB;
create user 'studentStackUser'@'localhost' identified by 'studentStack';
grant all privileges on studentStackDB.* to 'studentStackUser'@'localhost'
create table branch (
code int primary key auto_increment,
title varchar(50) unique not null
)
create table country (
country_id int primary key auto_increment,
country_name varchar(50) unique not null
)
create table state
(
state_id int primary key auto_increment,
state_name varchar(50) unique not null,
country int not null,
foreign key (country) references country(country_id)
)
create table city (
city_id int primary key auto_increment,
city_name varchar(50) unique not null,
state int not null,
foreign key (state) references state(state_id) 
)
create table college (
college_id int primary key auto_increment,
college_name varchar(100) unique not null,
city int not null,
foreign key (city) references city(city_id) 
)
create table student (
student_id int primary key auto_increment,
student_name varchar(100) unique not null,
branch int not null,
country int not null,
state int not null,
city int not null,
college int not null,
email_id varchar(50) not null unique,
phone_no varchar(10) not null unique,
date_of_birth date not null,
gender varchar(1) not null,
is_indian boolean not null,
foreign key (branch) references branch(code),
foreign key (country) references country(country_id),
foreign key (state) references state(state_id),
foreign key (city) references city(city_id),
foreign key (college) references college(college_id)
)
insert into branch (title) values ("Electronics and communication");
insert into city (city_name,state) values ("Stanford",4);
insert into college (college_name,city) values ("University of california",1);