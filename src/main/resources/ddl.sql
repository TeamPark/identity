CREATE SEQUENCE identity_id_seq
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9999999999
    START 1
    CACHE 1;

CREATE TABLE identity (
    id integer primary key,
    email varchar(50) NOT NULL
);