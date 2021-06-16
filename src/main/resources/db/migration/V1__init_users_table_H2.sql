drop table if exists users;
create table users(
    id int primary key auto_increment,
    user_name varchar(100) not null,
    password varchar(100) not null,
    roles varchar(100) not null,
    active bit
)