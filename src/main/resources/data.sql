DROP TABLE IF EXISTS patients;

CREATE TABLE patients (
    id_patient bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(120) NOT NULL,
    surname VARCHAR(120) NOT NULL,
    gender VARCHAR(120) NOT NULL,
    birth_date DATE,
    age int
);

INSERT INTO patients (name, surname, gender, birth_date, age)
VALUES ('Jan', 'Kowalski','M','2010-01-01','35'),
       ('Marek', 'Koparka','M','2010-01-01','45'),
       ('Piotrek', 'Pietruszka','M','2010-01-01','34');