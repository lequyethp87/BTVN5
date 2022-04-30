-- create database
DROP DATABASE IF EXISTS TestingSystem_Assignment_5_Advance;
CREATE DATABASE TestingSystem_Assignment_5_Advance;
USE TestingSystem_Assignment_5_Advance;


DROP TABLE IF EXISTS `Position`;
CREATE TABLE `Position`(
	PosID 				INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    PositionName 	NVARCHAR(30) NOT NULL UNIQUE KEY,
    CreateDate		DATE DEFAULT (DATE(now()))  
);

DROP TABLE IF EXISTS `Member`;
CREATE TABLE `Member`(
	ID 				INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Name` 			NVARCHAR(30) NOT NULL UNIQUE KEY,
    PositionID		INT UNSIGNED ,
    Salary			DOUBLE,
    ProfileImgUrl	VARCHAR(200),
    FbLink			VARCHAR(200),
    FOREIGN KEY (PositionID) REFERENCES `Position`(PosID) ON UPDATE CASCADE
);

INSERT INTO `Position`(PositionName)
 VALUES ('Director'),('Developer'),('Testing'),('Staff');
INSERT INTO `Member`(`Name`,PositionID,Salary) VALUES('LE DINH QUYET',3,10.6);