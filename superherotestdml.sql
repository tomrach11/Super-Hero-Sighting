DROP DATABASE IF EXISTS SuperHeroTestDB;

CREATE DATABASE SuperHeroTestDB;

use SuperHeroTestDB;

CREATE TABLE Superpower (
	superpowerId INT PRIMARY KEY auto_increment,
    type VARCHAR(30) NOT NULL
);

CREATE TABLE characters (
characterId INT PRIMARY KEY auto_increment,
name VARCHAR(50) NOT NULL,
description VARCHAR(225) NOT NULL,
superpowerId INT NOT NULL,
FOREIGN KEY fk_characters_superpower (superpowerId)
		REFERENCES superpower(superpowerId),
type VARCHAR(7) NOT NULL);

CREATE TABLE Location(
locationId INT PRIMARY KEY auto_increment,
latitude DECIMAL(9,6) NOT NULL,
longitude DECIMAL(8,6) NOT NULL,
street VARCHAR(50) NOT NULL,
city VARCHAR(50) NOT NULL,
state CHAR(2) NOT NULL,
zipcode CHAR(5) NOT NULL);

CREATE TABLE Organization(
organizationId INT PRIMARY KEY auto_increment,
name VARCHAR(50) NOT NULL,
description VARCHAR(225) NOT NULL,
locationId INT NOT NULL,
FOREIGN KEY fk_organization_location (locationId)
		REFERENCES location(locationId),
phone CHAR(10) NOT NULL,
email VARCHAR(50) NOT NULL);

CREATE TABLE Sighting(
sightingId INT PRIMARY KEY auto_increment,
characterId INT NOT NULL,
locationId INT NOT NULL,
FOREIGN KEY fk_sighting_character (characterId)
		REFERENCES characters(characterId),
FOREIGN KEY fk_sighting_location (locationId)
		REFERENCES location(locationId),
sightdate date);

CREATE TABLE Organization_character(
organizationId INT NOT NULL,
characterId INT NOT NULL,
PRIMARY KEY pk_organization_character (organizationId, characterId),
FOREIGN KEY fk_organization_character_organization (organizationId)
		REFERENCES Organization(organizationId),
FOREIGN KEY fk_organization_character_character (characterId)
		REFERENCES characters(characterId)
		);
