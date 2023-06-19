CREATE DATABASE IF NOT EXISTS recetario;
use recetario;

CREATE TABLE IF NOT EXISTS Receta(
    ID integer PRIMARY KEY AUTO_INCREMENT,
    imagenPrincipal text DEFAULT (NULL),
    nombre text DEFAULT (NULL),
    duracion text DEFAULT (NULL),
    dificultad text DEFAULT (NULL),
    descripcion text DEFAULT (NULL),
    tags text DEFAULT (NULL),
    ingredientes text DEFAULT (NULL),
	  pasos text DEFAULT (NULL)  
);

CREATE TABLE IF NOT EXISTS Ingrediente(
ID integer PRIMARY KEY AUTO_INCREMENT,
nombre text DEFAULT(NULL),
precio text DEFAULT 0,
origen text DEFAULT (NULL),
estado_preferente text DEFAULT 0
);

CREATE TABLE IF NOT EXISTS Usuario(
		id INTEGER PRIMARY KEY AUTO_INCREMENT,
		nombre TEXT DEFAULT (NULL),
		apellido1 TEXT DEFAULT (NULL),
		apellido2 TEXT DEFAULT (NULL),
		email TEXT DEFAULT (NULL),
		usuario TEXT DEFAULT (NULL),
		psw TEXT DEFAULT (NULL)
);

INSERT INTO receta(imagenPrincipal, nombre, duracion, dificultad, descripcion, tags, ingredientes, pasos)
values('assets/prueba.jpg', 'Arroz con curry', '20 minutos', 'Nivel fácil', 'Receta sencilla de prueba', 'Arroz|Curry|Primero|Rápido', '2,120|6,5|1,2L', 
'Paso de prueba 1///assets/prueba.jpg||Paso de prueba 2///assets/prueba.jpg||');

INSERT INTO receta(imagenPrincipal, nombre, duracion, dificultad, descripcion, tags, ingredientes, pasos)
values('assets/prueba.jpg', 'Arroz con curry', '20 minutos', 'Nivel fácil', 'Receta sencilla de prueba N2', 'Arroz|Curry|Primero|Rápido', '2,120|6,5|1,2L', 
'Paso de prueba 1///assets/prueba.jpg ||Paso de prueba 2///assets/prueba.jpg||');

INSERT INTO Ingrediente(nombre, precio, origen, estado_preferente)
VALUES('Arroz', '1.5 €/Kg', 'Mercadona', null);

INSERT INTO Ingrediente(nombre, precio, origen, estado_preferente)
VALUES('Patata', '1.5 €/Kg', 'Carrefour', 'Blandas');

INSERT INTO Usuario(nombre, apellido1, apellido2, email, usuario, psw)
VALUES('Pepe', 'Pérez', 'Palomino', 'pepepepa@gmail.com', 'pepe1986', '123456');