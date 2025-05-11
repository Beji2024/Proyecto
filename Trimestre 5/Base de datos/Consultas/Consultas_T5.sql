-- registro categoria
INSERT INTO categoria (nom_cat) VALUES('Hombre');
INSERT INTO categoria (nom_cat) VALUES('Mujer');
INSERT INTO categoria (nom_cat) VALUES('Niños');

SELECT * FROM categoria;

-- subcategoria
INSERT INTO subcategoria (nom_sub, cat_sub) VALUES('Deportivo', 1);
INSERT INTO subcategoria (nom_sub, cat_sub) VALUES('Formal', 1);
INSERT INTO subcategoria (nom_sub, cat_sub) VALUES('Chanclas', 1);
INSERT INTO subcategoria (nom_sub, cat_sub) VALUES('Tacones', 2);
INSERT INTO subcategoria (nom_sub, cat_sub) VALUES('Sandalias', 2);
INSERT INTO subcategoria (nom_sub, cat_sub) VALUES('Colegial', 3);
INSERT INTO subcategoria (nom_sub, cat_sub) VALUES('Deportivo', 3);

SELECT * FROM subcategoria;

-- mercancia
INSERT INTO mercancia (nombre, talla, material, color, sub_mer, cantidad) VALUES ('sport10', 40, 'cuero', 'negro', 1, 32);
UPDATE mercancia SET precio_venta = 13000 WHERE id_pro = 1;
UPDATE mercancia SET precio_compra = 10000 WHERE id_pro = 1;
INSERT INTO mercancia (nombre, talla, material, color, sub_mer, cantidad, precio_venta, precio_compra) VALUES ('Ksual', 39, 'cuero-sintetico', 'cafe', 2, 32, 30000, 22000);
INSERT INTO mercancia (nombre, talla, material, color, sub_mer, cantidad, precio_venta, precio_compra) VALUES ('LAcoste', 37, 'tela', 'gris', 2, 21, 20000, 12000);
Update mercancia set sub_mer = 2 WHERE id_pro = 2;

SELECT * FROM mercancia;
