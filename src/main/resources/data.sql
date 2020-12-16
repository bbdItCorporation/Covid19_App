--DROP TABLE IF EXISTS patients;
--DROP TABLE IF EXISTS users;
--
--CREATE TABLE patients(
--    patientID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
--    name VARCHAR(120),
--    surname VARCHAR(120),
--    sex VARCHAR(120),
--    birth_date DATE,
--    age int,
--    date_positive DATE,
--    date_information DATE,
--    residence_city nchar(250),
--    residence_district nchar(250),
--    stay_city nchar(250),
--    stay_district nchar(250),
--    hospitalized BOOLEAN,
--    hospital_name nchar(250),
--    quarantine BOOLEAN,
--    supervision BOOLEAN,
--    laboratorium nchar(250),
--    infection_source nchar(1000),
--    telephone_number nchar(100),
--    user_id int
--);
--
--CREATE TABLE users(
--    userID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
--    login VARCHAR(120),
--    password VARCHAR(120),
--    adminRole BOOLEAN
--);
--
--
----INSERT INTO patients (Name, Surname, Sex, birth_date, Age)
----VALUES ('Jan', 'Kowalski','M','2010-01-01','35'),
----       ('Marek', 'Koparka','M','2010-01-01','45'),
----       ('Piotrek', 'Pietruszka','M','2010-01-01','34');