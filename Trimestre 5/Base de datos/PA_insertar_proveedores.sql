DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_insertar_proveedores`( IN p_nit INT,
    IN p_nombre VARCHAR(50),
    IN p_direccion VARCHAR(40),
    IN p_telefono VARCHAR(20),
    IN p_correo VARCHAR(40)
)
BEGIN
    INSERT INTO proveedores (nit, nombre, direccion, telefono, correo)
    VALUES (p_nit, p_nombre, p_direccion, p_telefono, p_correo);
END$$
DELIMITER ;