-- Insertar datos en la tabla cliente
INSERT INTO cliente (rut, nombre, fecha_nacimiento, anho_registro) VALUES (12345678, 'Juan Perez', '1994-10-25',2020);
INSERT INTO cliente (rut, nombre, fecha_nacimiento, anho_registro) VALUES (87654321, 'Maria Gonzalez', '1983-05-23',2019);
INSERT INTO cliente (rut, nombre, fecha_nacimiento, anho_registro) VALUES (11223344, 'Carlos Sanchez', '1972-07-02',2021);
INSERT INTO cliente (rut, nombre, fecha_nacimiento, anho_registro) VALUES (44332211, 'Ana Lopez', '1953-01-03',2018);
INSERT INTO cliente (rut, nombre, fecha_nacimiento, anho_registro) VALUES (99887766, 'Pedro Fernandez', '1969-10-25',2022);

-- Insertar datos en la tabla producto
INSERT INTO producto (cliente_rut, precio_producto, nombre_producto, categoria) VALUES (12345678, 15000, "TV LG", 'entretenimiento'); -- Producto 1 para Juan Pérez
INSERT INTO producto (cliente_rut, precio_producto, nombre_producto, categoria) VALUES (12345678, 35000, "Impresora Canon", 'computacion'); -- Producto 2 para Juan Pérez
INSERT INTO producto (cliente_rut, precio_producto, nombre_producto, categoria) VALUES (12345678, 20000, "Cama King Rosen", 'casa'); -- Producto 3 para Juan Pérez
INSERT INTO producto (cliente_rut, precio_producto, nombre_producto, categoria) VALUES (12345678, 25000, "iMac 2024", 'computacion'); -- Producto 1 para María González

INSERT INTO producto (cliente_rut, precio_producto, nombre_producto, categoria) VALUES (87654321, 18000, "Monitor AOC", 'computacion'); -- Producto 2 para María González
INSERT INTO producto (cliente_rut, precio_producto, nombre_producto, categoria) VALUES (87654321, 22000, "Audifonos JBL", 'entretenimiento'); -- Producto 3 para María González

INSERT INTO producto (cliente_rut, precio_producto, nombre_producto, categoria) VALUES (11223344, 12000, "Audifonos Sony", 'entretenimiento'); -- Producto 1 para Carlos Sánchez
INSERT INTO producto (cliente_rut, precio_producto, nombre_producto, categoria) VALUES (11223344, 45000, "Macbook 2023", 'computacion'); -- Producto 2 para Carlos Sánchez

INSERT INTO producto (cliente_rut, precio_producto, nombre_producto, categoria) VALUES (44332211, 17000, "Disco SSD 1T",'computacion'); -- Producto 3 para Carlos Sánchez
INSERT INTO producto (cliente_rut, precio_producto, nombre_producto, categoria) VALUES (44332211, 30000, "Escritorio en L", 'casa'); -- Producto 1 para Ana López
INSERT INTO producto (cliente_rut, precio_producto, nombre_producto, categoria) VALUES (44332211, 29000, "Licencia ChatGPT", 'computacion'); -- Producto 2 para Ana López
INSERT INTO producto (cliente_rut, precio_producto, nombre_producto, categoria) VALUES (44332211, 40000, "Tablet Samsung 2023", 'computacion'); -- Producto 3 para Ana López
INSERT INTO producto (cliente_rut, precio_producto, nombre_producto, categoria) VALUES (44332211, 50000, "Iphone 16Pro", 'computacion'); -- Producto 1 para Pedro Fernández
INSERT INTO producto (cliente_rut, precio_producto, nombre_producto, categoria) VALUES (44332211, 21000, "Ipad 2023", 'computacion'); -- Producto 2 para Pedro Fernández

INSERT INTO producto (cliente_rut, precio_producto, nombre_producto, categoria) VALUES (99887766, 32000, "PlayStation 5", 'entretenimiento'); -- Producto 3 para Pedro Fernández
