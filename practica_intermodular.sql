-- Crear base de datos
DROP DATABASE IF EXISTS practica_intermodular;
CREATE DATABASE practica_intermodular;
USE practica_intermodular;

-- Crear tabla Estrellas
CREATE TABLE Estrellas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    tipo_estrella VARCHAR(50) NOT NULL,
    radio DOUBLE NOT NULL,
    temperatura_superficial INT NOT NULL,
    distancia_media_tierra DOUBLE NOT NULL,
    composicion VARCHAR(50) NOT NULL,
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- Crear la tabla Planetas
CREATE TABLE Planetas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    radio DOUBLE NOT NULL,
    distancia_media_sol DOUBLE NOT NULL,
    periodo_orbital DOUBLE NOT NULL,
    temperatura_media INT NOT NULL,
    tipo_planeta ENUM('Rocoso', 'Gaseoso') NOT NULL,
    num_satelites INT DEFAULT 0,
    id_estrella INT NOT NULL,
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_estrella) REFERENCES Estrellas(id)
);

-- Creación de la tabla Satelites
CREATE TABLE Satelites (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    id_planeta INT NOT NULL,
    radio DOUBLE NOT NULL,
    distancia_media_planeta DOUBLE NOT NULL,
    periodo_orbital DOUBLE NOT NULL,
    temperatura_media INT NOT NULL,
    tipo_cuerpo ENUM('Sólido/Rocoso', 'Sólido/Hielo') NOT NULL,
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_planeta) REFERENCES Planetas(id)
);

-- Inserción de datos en la tabla Estrellas
INSERT INTO Estrellas (nombre, tipo_estrella, radio, temperatura_superficial, distancia_media_tierra, composicion)
VALUES
('Sol', 'G2V', 696340, 5500, 149.6, '74% Hidrógeno, 24% Helio, 2% Otros');

-- Inserción de datos en la tabla Planetas
INSERT INTO Planetas (nombre, radio, distancia_media_sol, periodo_orbital, temperatura_media, tipo_planeta, id_estrella)
VALUES
('Mercurio', 2439.7, 57.9, 88, 167, 'Rocoso', 1),
('Venus', 6051.8, 108.2, 225, 464, 'Rocoso', 1),
('Tierra', 6371, 149.6, 365.25, 15, 'Rocoso', 1),
('Marte', 3389.5, 227.9, 687, -65, 'Rocoso', 1),
('Júpiter', 69911, 778.5, 4333, -110, 'Gaseoso', 1),
('Saturno', 58232, 1429.4, 10759, -140, 'Gaseoso', 1),
('Urano', 25362, 2870.9, 30687, -195, 'Gaseoso', 1),
('Neptuno', 24622, 4498.3, 60190, -200, 'Gaseoso', 1);

-- Inserción de datos en la tabla Satelites
INSERT INTO Satelites (nombre, id_planeta, radio, distancia_media_planeta, periodo_orbital, temperatura_media, tipo_cuerpo)
VALUES
('Luna', 3, 1737.4, 384400, 27.3, -53, 'Sólido/Rocoso'),
('Fobos', 4, 11.1, 9378, 0.3, -40, 'Sólido/Rocoso'),
('Deimos', 4, 6.2, 23460, 1.3, -40, 'Sólido/Rocoso'),
('Ío', 5, 1821.6, 421700, 1.8, -143, 'Sólido/Rocoso'),
('Europa', 5, 1560.8, 670900, 3.5, -160, 'Sólido/Hielo'),
('Ganimedes', 5, 2634.1, 1070400, 7.2, -163, 'Sólido/Hielo'),
('Calisto', 5, 2410.3, 1882700, 16.7, -139, 'Sólido/Hielo'),
('Titán', 6, 2575.5, 1222000, 15.9, -179, 'Sólido/Hielo'),
('Encélado', 6, 252.1, 238000, 1.4, -201, 'Sólido/Hielo'),
('Titania', 7, 788.4, 435900, 8.7, -203, 'Sólido/Hielo'),
('Oberón', 7, 761.4, 583500, 13.5, -203, 'Sólido/Hielo');

DELIMITER //
-- Trigger de PL/SQL para actualizar el número de satélites
CREATE TRIGGER actualizar_numero_satelites
AFTER INSERT ON Satelites
FOR EACH ROW
BEGIN
    UPDATE Planetas SET num_satelites = num_satelites + 1 WHERE id = NEW.id_planeta;
END;

-- Trigger de PL/SQL para añadir la fecha de creación de planetas
CREATE TRIGGER actualizar_fecha_creacion_planetas
BEFORE INSERT ON Planetas
FOR EACH ROW
BEGIN
    SET NEW.fecha_creacion = CURRENT_TIMESTAMP;
END;

-- Trigger de PL/SQL para añadir la fecha de creación de satélites
CREATE TRIGGER actualizar_fecha_creacion_satelites
BEFORE INSERT ON Satelites
FOR EACH ROW
BEGIN
    SET NEW.fecha_creacion = CURRENT_TIMESTAMP;
END;