create database OWNERPETS;
use OWNERPETS;

CREATE TABLE Cities (
    PostalCode VARCHAR(5) PRIMARY KEY,
    City VARCHAR(50)
);

CREATE TABLE Breeds (
    BreedID INTEGER PRIMARY KEY,
    Breed VARCHAR(50)
);

CREATE TABLE Owners (
    OwnerID INTEGER PRIMARY KEY,
    PostalCode VARCHAR(5),
    Name VARCHAR(50),
    Phone VARCHAR(20),
    FOREIGN KEY (PostalCode) REFERENCES Cities(PostalCode)
);

CREATE TABLE Pets (
    PetID INTEGER PRIMARY KEY,
    PetName VARCHAR(50),
    BreedID INTEGER,
    FOREIGN KEY (BreedID) REFERENCES Breeds(BreedID)
);

CREATE TABLE OwnersPets (
    OwnerID INTEGER,
    PetID INTEGER,
    PRIMARY KEY (OwnerID, PetID),
    FOREIGN KEY (OwnerID) REFERENCES Owners(OwnerID),
    FOREIGN KEY (PetID) REFERENCES Pets(PetID)
);

INSERT INTO Cities (PostalCode, City) VALUES ('10012', 'New York');
INSERT INTO Cities (PostalCode, City) VALUES ('90001', 'Los Angeles');
INSERT INTO Cities (PostalCode, City) VALUES ('33101', 'Miami');


INSERT INTO Breeds (BreedID, Breed) VALUES (1, 'Yellow Lab');
INSERT INTO Breeds (BreedID, Breed) VALUES (2, 'Poodle');
INSERT INTO Breeds (BreedID, Breed) VALUES (3, 'Black Lab');


INSERT INTO Owners (OwnerID, PostalCode, Name, Phone) VALUES (1, '10012', 'David', '1111111');
INSERT INTO Owners (OwnerID, PostalCode, Name, Phone) VALUES (2, '90001', 'Rebecca', '2222222');
INSERT INTO Owners (OwnerID, PostalCode, Name, Phone) VALUES (3, '33101', 'Jordan', '3333333');


INSERT INTO Pets (PetID, PetName, BreedID) VALUES (1, 'Hunter', 1);
INSERT INTO Pets (PetID, PetName, BreedID) VALUES (2, 'Michael', 2);
INSERT INTO Pets (PetID, PetName, BreedID) VALUES (3, 'Bear', 3);


INSERT INTO OwnersPets (OwnerID, PetID) VALUES (1, 1);
INSERT INTO OwnersPets (OwnerID, PetID) VALUES (1, 2);
INSERT INTO OwnersPets (OwnerID, PetID) VALUES (2, 3);
