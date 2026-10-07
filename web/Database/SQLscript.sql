CREATE DATABASE empresa;
USE empresa;

CREATE TABLE empleados (
id int auto_increment KEY,
nombre varchar(255) NOT NULL,
departamento varchar(255) NOT NULL
);
INSERT INTO empleados(nombre,departamento)
VALUES ('Rafael','Contabilidad');
INSERT INTO empleados(nombre,departamento)
VALUES ('Paula','Sistemas');
INSERT INTO empleados(nombre,departamento)
VALUES ('Gabriela','Recursos Humanos');
INSERT INTO empleados(nombre,departamento)
VALUES ('Andrés','Ventas');
INSERT INTO empleados(nombre,departamento)
VALUES ('Pablo','Logística');
SELECT * FROM empleados;
