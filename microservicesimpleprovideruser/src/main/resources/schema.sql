drop table lkw if exists;
create table lkw (id bigint generated by default as identity,username varchar(40),myname varchar(20),
age int(3),balance decimal(10,2),primary key (id));