create table car (
   id integer not null,
   carName varchar(255) not null,
   carStatus varchar(32) not null,
   isCarRented number(1),
   carMilage bigint,
   primary key(id)
);

create table users (
    id integer not null,
    username varchar(50) not null,
    rentalPrivilege varchar(30) not null,
    primary key(id)
);