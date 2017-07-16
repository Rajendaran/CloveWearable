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
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
) ENGINE=innodb DEFAULT CHARSET=utf8;

-- Create temperature table
DROP TABLE IF EXISTS temperature;
CREATE TABLE temperature (
  id INT NOT NULL AUTO_INCREMENT,
  pincode VARCHAR(15) NOT NULL DEFAULT 0,
  current_temperature DOUBLE NOT NULL DEFAULT 0.0,
  country VARCHAR(50),
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
) ENGINE=innodb DEFAULT CHARSET=utf8;


