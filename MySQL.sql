show DATABASES;
CREATE DATABASE testDB; 
USE testDB;

CREATE TABLE User(                               
id varchar (30) not null,
password varchar (30) not null,
primary key(id)         
);

CREATE TABLE checkLoginTime(                               
id varchar (30) not null,
logintime varchar (30) not null
);







