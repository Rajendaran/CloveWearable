-- Create database
CREATE DATABASE IF NOT EXISTS clovewearable;

-- Use clovewearable database
USE clovewearable;

-- Create users table
DROP TABLE IF EXISTS users;
CREATE TABLE users (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(50),
  email VARCHAR(50),
  pincode VARCHAR(15),
  PRIMARY KEY (id)
) ENGINE=innodb DEFAULT CHARSET=utf8;


