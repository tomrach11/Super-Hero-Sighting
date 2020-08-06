INSERT INTO location (latitude, longitude, street, city, state, zipcode) values (74.22, 11.23, "Grove", "Brooklyn", "NY", "12345");
INSERT INTO location (latitude, longitude, street, city, state, zipcode) values (32.44, 12.2, "Canal", "Bronx", "NY", "11235");
INSERT INTO location (latitude, longitude, street, city, state, zipcode) values (22.22, 44.55, "Altantic", "Queens", "NY", "11226");
INSERT INTO location (latitude, longitude, street, city, state, zipcode) values (99.01, 02.99, "22nd", "Jersey", "NJ", "07097");
INSERT INTO location (latitude, longitude, street, city, state, zipcode) values (43.55, 77.23, "Da Ave", "Staten Island", "NY", "11236");
INSERT INTO location (latitude, longitude, street, city, state, zipcode) values (55.22, 88.66, "5th Ave", "New York", "NY", "10022");
INSERT INTO location (latitude, longitude, street, city, state, zipcode) values (77.87, 55.72, "Tech Hire", "Queens", "NY", "10022");
INSERT INTO organization (name, description, locationId, phone, email) values ("Corner", "The cornerstore at the end of your block", 1, "0231564889", "corner@gmail.com");
INSERT INTO organization (name, description, locationId, phone, email) values ("Big Apple", "New Yorks Finest", 2, "2123304498", "BigApple@gmail.com");
INSERT INTO organization (name, description, locationId, phone, email) values ("Fishermen", "Once we sink our hooks in, we reel in the bad guys", 3, "1231564889", "Fishermen@gmail.com");
INSERT INTO organization (name, description, locationId, phone, email) values ("Fat Alberts", "Hey, Hey, Hey, Don't think you'll run away", 4, "0231564889", "corner@gmail.com");
INSERT INTO organization (name, description, locationId, phone, email) values ("Banana Peel Gang", "We'll catch you slipping", 5, "3333333333", "BPG@gmail.com");
INSERT INTO organization (name, description, locationId, phone, email) values ("Chicken Crossing Club", "Stick with us and you'll get to the other side", 6, "5555555555", "ccc@gmail.com");
INSERT INTO Superpower (type) VALUES ("super speed");
INSERT INTO Superpower (type) VALUES ("decay");
INSERT INTO Superpower (type) VALUES ("telepathy");
INSERT INTO Superpower (type) VALUES ("matter manipulation");
INSERT INTO Superpower (type) VALUES ("steal powers");
INSERT INTO Superpower (type) VALUES ("reality warping");
INSERT INTO Superpower (type) VALUES ("super saiyan ability");
INSERT INTO Superpower (type) VALUES ("one for all");
INSERT INTO Superpower (type) VALUES ("superhuman strength");
INSERT INTO Superpower (type) VALUES ("super intellect");
INSERT INTO Superpower (type) VALUES ("time control");
INSERT INTO Superpower (type) VALUES ("magnetism");
INSERT INTO Superpower (type) VALUES ("cancel out powers");
INSERT INTO characters (name, description, superpowerId, type) values ("Deku", "The Greatest Hero of All Time", 1, "Hero");
INSERT INTO characters (name, description, superpowerId, type) values ("Ichigo", "Bankai master flex", 2, "Hero");
INSERT INTO characters (name, description, superpowerId, type) values ("All For One", "All Powers will be mine", 3, "Villain");
INSERT INTO characters (name, description, superpowerId, type) values ("Son Goku", "Super Saiyan ", 4, "Hero");
INSERT INTO characters (name, description, superpowerId, type) values ("Frieza", "I will rule the universe", 5, "Villain");
INSERT INTO characters (name, description, superpowerId, type) values ("Tomura Shigaraki", "All decays before me", 6, "Villain");
INSERT INTO sighting (characterId, locationId, sightdate) values (1, 1, "2020-01-01");
INSERT INTO sighting (characterId, locationId, sightdate) values (2, 3, "2020-04-01");
INSERT INTO sighting (characterId, locationId, sightdate) values (4, 2, "2020-11-07");
INSERT INTO sighting (characterId, locationId, sightdate) values (5, 1, "2020-12-05");
INSERT INTO sighting (characterId, locationId, sightdate) values (3, 5, "2020-05-09");
INSERT INTO sighting (characterId, locationId, sightdate) values (1, 4, "2020-06-17");
INSERT INTO sighting (characterId, locationId, sightdate) values (2, 5, "2020-07-15");
INSERT INTO sighting (characterId, locationId, sightdate) values (3, 1, "2020-03-31");
INSERT INTO sighting (characterId, locationId, sightdate) values (6, 3, "2020-02-23");
INSERT INTO sighting (characterId, locationId, sightdate) values (6, 1, "2020-08-11");
INSERT INTO organization_character (characterId, organizationId) values 
(1, 2),
(1, 4),
(2, 1),
(2, 2),
(2, 3),
(2, 4),
(3, 5),
(3, 4),
(4, 5),
(5, 3),
(5, 5),
(6, 4)
