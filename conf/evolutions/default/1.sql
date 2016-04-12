# Users schema

# --- !Ups

CREATE TABLE foods (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    food_group varchar(255) NOT NULL,
    severity varchar(255) NOT NULL,
    information varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE treatments (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    information varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE symptoms (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    information varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

# --- !Downs
DROP TABLE foods;
DROP TABLE treatments;
DROP TABLE symptoms;
