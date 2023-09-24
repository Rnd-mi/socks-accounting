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
