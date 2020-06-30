DROP DATABASE IF EXISTS captcha_login_demo;

CREATE DATABASE captcha_login_demo;

USE captcha_login_demo;

CREATE TABLE user
(
    id       INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

INSERT INTO user (username, password)
values ('JOEY', 'EVELYN'),
       ('test', 'test');