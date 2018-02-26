create table IF NOT EXISTS ACTOR(
	dni varchar(25) PRIMARY KEY,
	nombre varchar(25),
	fechaNacimiento date
);

create table IF NOT EXISTS PELICULA(
	id int PRIMARY KEY,
	nombre varchar(25),
	fechaEstreno date
);