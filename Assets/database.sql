show databases;

create database grossaryStore;
use grossaryStore;


create table users(
	id varchar(50) primary key,
    name varchar(50) not null,
    email varchar(50) unique not null,
    walletPrice int not null,
    password varchar(50) not null,
    role varchar(50) not null,
    createdAt datetime default CURRENT_TIMESTAMP
);


create table products(
	id varchar(50) primary key,
    name varchar(50) not null,
    price int not null,
    description varchar(1000),
    vendorID varchar(50) references users(id),
    createdAt datetime default CURRENT_TIMESTAMP
);


create table orders(
	id varchar(50) primary key,
    customer varchar(50) references users(id),
    vendor varchar(50) references users(id),
    product varchar(50) references products(id),
    quantity int not null,
    totalPrice int not null,
    isAccepted boolean default false,
    orderedAt datetime default CURRENT_TIMESTAMP
);

desc users;
desc products;
desc orders;
