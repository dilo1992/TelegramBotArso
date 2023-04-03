create  table if not exists roles (id serial not null primary key,name varchar(20) not null);
-- create table  if not exists default_users (id serial not null primary key, login varchar(50) unique,
--     password varchar(500), role_id integer references roles);