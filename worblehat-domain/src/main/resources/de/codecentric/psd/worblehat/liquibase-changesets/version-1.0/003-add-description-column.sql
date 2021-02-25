-- liquibase formatted sql

-- changeset action:create_table_books
ALTER TABLE book
ADD description VARCHAR(2000);
