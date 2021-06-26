drop table if exists users;
create table users(
    id int primary key auto_increment,
    username varchar(100) not null unique,
    password varchar(100) not null,
    role varchar(100) not null,
    active bit
)