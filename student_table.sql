CREATE DATABASE student_db;

USE student_db;

CREATE TABLE students (
    name VARCHAR(100),
    prn INT PRIMARY KEY,
    branch VARCHAR(50),
    batch VARCHAR(20),
    cgpa FLOAT
);
