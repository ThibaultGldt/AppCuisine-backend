CREATE TABLE users (
    id int primary key generated always as identity,
    username varchar(255),
    email varchar(255)
);