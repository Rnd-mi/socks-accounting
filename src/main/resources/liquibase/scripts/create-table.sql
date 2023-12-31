--liquibase formatted sql

--changeset Rnd-mi:1
create table socks (
    id serial primary key,
    color varchar(50) not null,
    cottonPart smallint not null
        check(cottonPart >= 0 and cottonPart <= 100),
    quantity int not null
        check(quantity >= 0)
);

--changeset Rnd-mi:2
drop table socks;

--changeset Rnd-mi:3
create table socks (
    color varchar(50) primary key,
    cottonPart smallint not null
        check(cottonPart >= 0 and cottonPart <= 100),
    quantity int not null
        check(quantity >= 0)
);

--changeset Rnd-mi:4
drop table socks;

create table socks (
    id serial primary key,
    color varchar(50) not null,
    cotton_part smallint not null
        check(cotton_part >= 0 and cotton_part <= 100),
    quantity int not null
        check(quantity >= 0)
);

