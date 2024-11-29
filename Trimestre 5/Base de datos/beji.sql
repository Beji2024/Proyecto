CREATE DATABASE beji;
USE beji;

-- Tabla tipo_doc
CREATE TABLE tipo_doc(
  id_tipo_doc INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(20)
);

-- Tabla rol
CREATE TABLE rol(
  idRol INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(15)
);

-- Tabla proveedores
CREATE TABLE proveedores(
  nit INT PRIMARY KEY,
  nombre VARCHAR(50),
  direccion VARCHAR(40),
  telefono VARCHAR(20),  -- Cambié a VARCHAR para poder almacenar más formatos
  correo VARCHAR(40)
);

-- Tabla estado
CREATE TABLE estado(
  idestado INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(15)
);

-- Tabla categoria
CREATE TABLE categoria(
  idcat INT AUTO_INCREMENT PRIMARY KEY,
  nom_cat VARCHAR(25)
);

-- Tabla usuario
CREATE TABLE usuario(
  num_doc INT PRIMARY KEY,
  nombres VARCHAR(50),
  apellidos VARCHAR(50),
  direccion VARCHAR(50),
  correo VARCHAR(45),
  num_tel VARCHAR(20),  -- Cambié a VARCHAR para poder almacenar más formatos
  fec_nac DATE,
  t_doc INT,
  rol INT,
  CONSTRAINT fk_tipo_doc FOREIGN KEY (t_doc) REFERENCES tipo_doc(id_tipo_doc),
  CONSTRAINT fk_rol FOREIGN KEY (rol) REFERENCES rol(idRol)
);

-- Tabla registro_inventario
CREATE TABLE registro_inventario(
  idregistro INT AUTO_INCREMENT PRIMARY KEY,
  fec_ing DATETIME,
  id_user INT,
  CONSTRAINT fk_usuario FOREIGN KEY (id_user) REFERENCES usuario(num_doc)
);

-- Tabla ventas
CREATE TABLE ventas(
  idventas INT AUTO_INCREMENT PRIMARY KEY,
  fec_ven DATE,
  nom_com VARCHAR(50),
  correo VARCHAR(45),
  telefono VARCHAR(20),  -- Cambié a VARCHAR para poder almacenar más formatos
  direccion VARCHAR(45),
  ven_usu INT,
  CONSTRAINT fk_ven_usu FOREIGN KEY (ven_usu) REFERENCES usuario(num_doc)
);

-- Tabla subcategoria
CREATE TABLE subcategoria(
  id_sub INT AUTO_INCREMENT PRIMARY KEY,
  nom_sub VARCHAR(45),
  cat_sub INT,
  CONSTRAINT fk_cat_sub FOREIGN KEY (cat_sub) REFERENCES categoria(idcat)
);

-- Tabla mercancia
CREATE TABLE mercancia(
  id_pro INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50),
  talla TINYINT,
  material VARCHAR(30),
  color VARCHAR(20),
  sub_mer INT,
  CONSTRAINT fk_mer_sub FOREIGN KEY (sub_mer) REFERENCES subcategoria(id_sub)
);
ALTER TABLE mercancia
ADD COLUMN cantidad TINYINT ;

-- Tabla detalle_reg
CREATE TABLE detalle_reg(
  idmer_inv INT AUTO_INCREMENT PRIMARY KEY,
  cantidad TINYINT,
  det_mer INT,
  det_reginv INT,
  det_prov INT,
  CONSTRAINT fk_det_mer FOREIGN KEY (det_mer) REFERENCES mercancia(id_pro),
  CONSTRAINT fk_det_reginv FOREIGN KEY (det_reginv) REFERENCES registro_inventario(idregistro),
  CONSTRAINT fk_det_prov FOREIGN KEY (det_prov) REFERENCES proveedores(nit)
);

-- Tabla pedido
CREATE TABLE pedido(
  idpedido INT AUTO_INCREMENT PRIMARY KEY,
  fec_ped DATE,
  ped_prov INT,
  ped_est INT,
  ped_user INT,
  CONSTRAINT fk_pedido_prov FOREIGN KEY (ped_prov) REFERENCES proveedores(nit),
  CONSTRAINT fk_ped_est FOREIGN KEY (ped_est) REFERENCES estado(idestado),
  CONSTRAINT fk_ped_user FOREIGN KEY (ped_user) REFERENCES usuario(num_doc)
);

-- Tabla detalle_ven
CREATE TABLE detalle_ven(
  id_detven INT AUTO_INCREMENT PRIMARY KEY, 
  cantidad TINYINT(2),
  precio_uni DECIMAL(10,2),  -- Cambié a DECIMAL para mayor precisión
  precio_tt DECIMAL(10,2),  
  det_v_ven INT,
  det_v_mer INT,
  CONSTRAINT fk_detven_ven FOREIGN KEY (det_v_ven) REFERENCES ventas(idventas),
  CONSTRAINT fk_det_v_mer FOREIGN KEY (det_v_mer) REFERENCES mercancia(id_pro)
);

-- Tabla detalle_ped
CREATE TABLE detalle_ped(
  iddet_ped INT AUTO_INCREMENT PRIMARY KEY,
  cantidad TINYINT(2),
  precio_uni DECIMAL(10,2),  
  precio_tt DECIMAL(10,2),  
  det_p_mer INT,
  det_p_ped INT,
  CONSTRAINT fk_det_p_mer FOREIGN KEY (det_p_mer) REFERENCES mercancia(id_pro),
  CONSTRAINT fk_det_p_ped FOREIGN KEY (det_p_ped) REFERENCES pedido(idpedido)
);

DELIMITER $$

CREATE PROCEDURE PA_agregar_producto_inventario(
    IN id_mer INT,           -- ID del producto
    IN cant TINYINT,         -- Cantidad a ingresar
    IN id_user INT,          -- Usuario que realiza la acción
    IN nit INT               -- Proveedor
)
BEGIN
    DECLARE fecha_actual DATETIME;

    SET fecha_actual = NOW();  -- Obtener la fecha y hora actuales

    -- Insertar en el registro de inventario
    INSERT INTO registro_inventario (fec_ing, id_user) 
    VALUES (fecha_actual, id_user);

    -- Insertar detalle del inventario (cantidad de productos)
    INSERT INTO detalle_reg (cantidad, det_mer, det_reginv, det_prov) 
    VALUES (cant, id_mer, LAST_INSERT_ID(), nit);

    -- Actualizar la cantidad en la tabla mercancia
	UPDATE mercancia
    SET cantidad = cantidad + cant
    WHERE id_pro = id_mer;
END$$

DELIMITER ;
DROP DATABASE beji;