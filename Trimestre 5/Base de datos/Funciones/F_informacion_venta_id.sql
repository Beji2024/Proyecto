CREATE DEFINER=`root`@`localhost` FUNCTION `informacion_venta_id`(id_venta INT) RETURNS varchar(255) CHARSET utf8mb4 COLLATE utf8mb4_general_ci
    DETERMINISTIC
BEGIN
    DECLARE info_venta VARCHAR(255);

    SELECT CONCAT('Cliente: ', nom_com, ', Correo: ', correo, ', Teléfono: ', telefono) 
    INTO info_venta
    FROM ventas
    WHERE idventas = id_venta;

    RETURN info_venta;
END