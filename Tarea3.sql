DROP database IF exists ClientesDB3;
CREATE DATABASE ClientesDB3;

USE ClientesDB3;

CREATE TABLE Cientificos (
    id INT(11) NOT NULL AUTO_INCREMENT,
    dni INT(11) DEFAULT NULL,
    nombre VARCHAR(250) DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Proyecto (
    id INT(11) NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(250) DEFAULT NULL,
    horas INT(11) DEFAULT NULL,
    PRIMARY KEY (id)
);

-- Crear la tabla Videos
CREATE TABLE Asignado_a (
    id_cien INT(11) NOT NULL,
    id_proy INT(11) NOT NULL,
    PRIMARY KEY (id_cien,id_proy),
    CONSTRAINT cientificos_fk FOREIGN KEY (id_cien) REFERENCES Cientificos(id) ON DELETE CASCADE,
    CONSTRAINT proyectos_fk FOREIGN KEY (id_proy) REFERENCES Proyecto(id) ON DELETE CASCADE
);

INSERT INTO Cientificos (dni, nombre) VALUES
(123456789, 'Juan Pérez'),
(987654321, 'María González'),
(456789123, 'Luis Rodríguez'),
(789123456, 'Ana Martínez'),
(321654987, 'Carlos Sánchez');

INSERT INTO Proyecto (nombre, horas) VALUES
('Proyecto A', 100),
('Proyecto B', 150),
('Proyecto C', 200),
('Proyecto D', 75),
('Proyecto E', 120);

INSERT INTO Asignado_a (id_cien, id_proy) VALUES
(1, 1),  -- Juan Pérez asignado al Proyecto A
(2, 2),  -- María González asignada al Proyecto B
(3, 3),  -- Luis Rodríguez asignado al Proyecto C
(4, 4),  -- Ana Martínez asignada al Proyecto D
(5, 5);  -- Carlos Sánchez asignado al Proyecto E

