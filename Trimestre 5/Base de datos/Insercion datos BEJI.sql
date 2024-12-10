use beji;
-- isercion tabla tipo de documento
INSERT INTO tipo_doc VALUES(1,'TI');
INSERT INTO tipo_doc VALUES(2,'CC');
INSERT INTO tipo_doc VALUES(3,'TE');

-- insercion tabla rol
INSERT INTO rol VALUES(1,'ADMINISTRADOR');
INSERT INTO rol VALUES(2,'BODEGUERO');
INSERT INTO rol VALUES(3,'VENDEDOR');

-- insercion tabla provedores
CALL PA_insertar_proveedores (104, 'super calzado', 'calle 80 #11-11', 321054867, 'super@gmail.com',189.99);
CALL PA_insertar_proveedores(102, 'mundo calzado', 'calle 140 #88-13',424255341 ,'mundocalzado@hotmail.com',255.990);
CALL PA_insertar_proveedores(103, 'calzado real', 'calle 1 #19-33', 555123456, 'realcalzado@hotmail.com',320.450);

-- insercion tabla estado
INSERT INTO estado VALUES(1,'ENVIADO');
INSERT INTO estado VALUES(2,'EN PROCESO');

-- insercion tabla categoria
CALL PA_crear_categoria(null,'HOMBRE');
CALL PA_crear_categoria(null,'MUJER');
CALL PA_crear_categoria(null,'NIÑO');

-- insercion tabla SUBCATEGORIA datos= nombre de subcategoria, id categoria
CALL PA_crear_Subcategoria('Mocasin',1);
CALL PA_crear_Subcategoria('Botas',1);
CALL PA_crear_Subcategoria('Tacones',3);
CALL PA_crear_Subcategoria('Botines',3);
CALL PA_crear_Subcategoria('Sandalias',3);
CALL PA_crear_Subcategoria('Deportivo',2);
CALL PA_crear_Subcategoria('Casual',2);
CALL PA_crear_Subcategoria('botas',2);


-- insercion tabla usuario datos=cc, nombre, apellido, direccion, correo,cel, fecha de nacimiento, tipo de cc, rol
CALL PA_insertar_Usuario(15482459,'JORGE','CARRASCAL MORALES','CALLE 11 #11-49','jorge34@hotmail.com',
'3105483215','1990-01-04',2,1);
CALL PA_insertar_Usuario(1325448,'CAMILO','ANDRADE SERPA','CALLE 22 #22-34','cami645@hotmail.com',
'3225684210','1996-11-01',2,2);
CALL PA_insertar_Usuario(10325644,'MARLON','HAFFID CERVANTES','CALLE 1 #34-02','marhaffid@hotmail.com',
'3225684210','1999-05-23',2,3);

-- insercion tabla mercancia datos= cantidad,nombre,talla, precio venta,material,color,subcategoria
CALL PA_insertar_mercancia(11, 'PUMA', 38, 155.50, 'Algodón', 'Rojo', 2);
CALL PA_insertar_mercancia(9, 'NIKE', 40, 200.50, 'Algodón', 'Blancos', 1);
CALL PA_insertar_mercancia(5,'ADIDAS',37,180.99,'Tela','azules',2);

-- actualizar un dato
UPDATE mercancia
SET precio = 200000
WHERE id_pro = 106;

-- funcion para hacer un para registrar los productos datos id mercancia, cantidad, cc usuario que hace el pedido,nit proveedor
 CALL PA_productos_nuevos(3,20,15482459,101);

-- funcion para hacer un pedido DATOS= fecha, nit proveedor, cc usuario que hace el pedido, productos a reabastecer   
CALL PA_realizar_pedido(now(),104, 15482459, '[{"id_pro":3, "cantidad": 10}]');

-- insercion tabla ventas now() fecha, nombre y apellido, correo, cel, direccion,cc del vendedor, productos
call PA_ventas(now(),'andres rodrigez','ande-3@hotmail.com','3748234566','calle 22',10325644,'[{"id_pro": 1, "cantidad": 21}]');

-- funcion para ver el stock disponible
select F_stock_disponible(101);

-- insercion tabla 
