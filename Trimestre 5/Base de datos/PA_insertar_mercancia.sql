CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_insertar_mercancia`(
    IN p_cantidad TINYINT,
    IN p_nombre VARCHAR(50),
    IN p_talla TINYINT,
    IN p_precio_venta DOUBLE,
    IN p_material VARCHAR(30),
    IN p_color VARCHAR(20),
    IN p_sub_mer INT
)
BEGIN
    INSERT INTO mercancia (cantidad, nombre, talla, precio_venta, material, color, sub_mer)
    VALUES (p_cantidad, p_nombre, p_talla, p_precio_venta, p_material, p_color, p_sub_mer);
END