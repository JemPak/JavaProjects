DROP SCHEMA IF EXISTS DbTodoLoBuenoSAS ;
CREATE SCHEMA IF NOT EXISTS DbTodoLoBuenoSAS;
USE DbTodoLoBuenoSAS;

CREATE TABLE producto (
  idproducto INT UNIQUE,
  nombre VARCHAR(45) NOT NULL,
  precio DECIMAL(8,2) NOT NULL,
  PRIMARY KEY (idproducto)
  );
  
INSERT INTO producto  VALUES (327, "tornillo el general", 93277.00);  
INSERT INTO producto  VALUES (278, "champagne", 15728.00);  
INSERT INTO producto  VALUES (190, "mora", 63781.00);  
INSERT INTO producto  VALUES (087, "cereal", 33796.00);  
INSERT INTO producto  VALUES (343, "garbanzo", 86495.00);  
INSERT INTO producto  VALUES (091, "vino espumoso", 47392.00);  
INSERT INTO producto  VALUES (772, "arroz", 67370.00);  
INSERT INTO producto  VALUES (999, "aguardiente", 69188.00);  
INSERT INTO producto  VALUES (333, "condimentos", 3025.00);  
INSERT INTO producto  VALUES (165, "cerezas dulces", 96453.00);  
INSERT INTO producto  VALUES (202, "aguardiente", 46004.00);  

DROP TABLE IF EXISTS Bodega;
CREATE TABLE Bodega (
  idBodega INT,
  nombre VARCHAR(45) NOT NULL,
  direccion VARCHAR(45) NOT NULL,
  PRIMARY KEY (idBodega)
  );

INSERT INTO bodega VALUES (111, "la amistad","Cra 78 # 85 -45");
INSERT INTO bodega VALUES (222, "santa isabel","Calle 34 # 45 -85");
INSERT INTO bodega  VALUES (333, "santa cecilia","Cra 89 # 54 - 39");

DROP TABLE IF EXISTS almacena; 
CREATE TABLE almacena (
  idBodega INT ,
  idproducto INT,  
  cantidad INT NOT NULL,
  FOREIGN KEY (idBodega) references Bodega(idBodega),
  FOREIGN KEY (idproducto) references producto(idproducto)
  );
  
INSERT INTO almacena VALUES ((
select idBodega from Bodega where nombre="la amistad"),
(select idproducto from producto where nombre="tornillo el general"),
 65);
INSERT INTO almacena VALUES ((
select idBodega from Bodega where nombre="la amistad"),
(select idproducto from producto where nombre="cereal"),
 11);
INSERT INTO almacena VALUES ((
select idBodega from Bodega where nombre="la amistad"),
(select idproducto from producto where nombre="cerezas dulces"),
 48);
INSERT INTO almacena VALUES ((
select idBodega from Bodega where nombre="santa isabel"),
(select idproducto from producto where nombre="champagne"),
 63);
INSERT INTO almacena VALUES ((
select idBodega from Bodega where nombre="santa isabel"),
(select idproducto from producto where nombre="vino espumoso"),
 85);
INSERT INTO almacena VALUES ((
select idBodega from Bodega where nombre="santa isabel"),
(select idproducto from producto where nombre="mora"),
 35);
INSERT INTO almacena VALUES ((
select idBodega from Bodega where nombre="santa cecilia"),
(select idproducto from producto where nombre="mora"),
 13);
INSERT INTO almacena VALUES ((
select idBodega from Bodega where nombre="santa cecilia"),
(select idproducto from producto where nombre="arroz"),
 19);
 
 DROP TABLE IF EXISTS empleado;
CREATE TABLE empleado (
  idBodega INT ,
  idEmpleado INT UNIQUE,  
  nombre VARCHAR(45) NOT NULL,
  edad INT NOT NULL,
  PRIMARY KEY (idempleado),
  FOREIGN KEY (idBodega) references Bodega(idBodega)
  );

INSERT INTO empleado VALUES ((select idBodega from Bodega where nombre="la amistad"),0034, "Sylvester Leonard", 24);
INSERT INTO empleado  VALUES ((select idBodega from Bodega where nombre="la amistad"),0256, "Ferdinand Dixon", 23); 
INSERT INTO empleado  VALUES ((select idBodega from Bodega where nombre="la amistad"),2390, "Amanda Ayala", 18);
INSERT INTO empleado  VALUES ((select idBodega from Bodega where nombre="la amistad"),0081, "Stephen I. Caldwell", 18);
INSERT INTO empleado  VALUES ((select idBodega from Bodega where nombre="la amistad"),3021, "Abraham Shepherd", 19);
INSERT INTO empleado  VALUES ((select idBodega from Bodega where nombre="santa isabel"),2093, "Libby J. Hendricks", 51);
INSERT INTO empleado  VALUES ((select idBodega from Bodega where nombre="santa isabel"),1121,"Sebastian C. Fleming", 50); 
INSERT INTO empleado  VALUES ((select idBodega from Bodega where nombre="santa cecilia"),0737,"Taylor Z. Oliver", 37);  
INSERT INTO empleado  VALUES ((select idBodega from Bodega where nombre="santa cecilia"),7825,"Nora D. Erickson", 32);  
INSERT INTO empleado  VALUES ((select idBodega from Bodega where nombre="santa cecilia"),5100,"Leila Huffman", 34);  
INSERT INTO empleado  VALUES ((select idBodega from Bodega where nombre="santa cecilia"),0045,"Colby M. Stephenson", 31);

