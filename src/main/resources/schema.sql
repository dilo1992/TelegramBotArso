create  table if not exists roles (id serial not null primary key,name varchar(20) not null);
create table if not exists products
(
    id                       bigint auto_increment
    primary key,
    model_of_type_of_product varchar(255) null,
    price                    double       null,
    type_of_product          varchar(255) null,
    information              varchar(255) null
    );