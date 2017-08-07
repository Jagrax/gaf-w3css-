CREATE DATABASE gafdb;

CREATE TABLE Estados (
	id INT NOT NULL,
	name VARCHAR(20) NOT NULL,
	color VARCHAR(20) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE Talleres (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL,
	address VARCHAR(255) NOT NULL,
	primary_phone VARCHAR(20),
	secondary_phone VARCHAR(20),
	employees_quantity INT NOT NULL,
	estado INT NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (estado) REFERENCES Estados(id)
);

CREATE TABLE Cortes (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  clothes_quantity INT NOT NULL,
  first_due_date DATE NOT NULL,
  second_due_date DATE NOT NULL,
  price DOUBLE NOT NULL,
  taller INT NOT NULL,
  from_size DOUBLE NOT NULL,
  to_size DOUBLE NOT NULL,
  hoja_de_corte VARCHAR(255),
  estado INT NOT NULL,
  comments VARCHAR(255),
  clothes_delivered INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (estado) REFERENCES Estados(id),
  FOREIGN KEY (taller) REFERENCES Talleres(id)
);