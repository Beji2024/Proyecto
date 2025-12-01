CREATE DEFINER=`root`@`localhost` FUNCTION `total_vendido_tiempo`(fecha_inicio DATE, fecha_fin DATE) RETURNS decimal(10,2)
    DETERMINISTIC
BEGIN
    DECLARE total_ventas DECIMAL(10,2);

    SELECT SUM(detalle_ven.precio_tt) 
    INTO total_ventas
    FROM detalle_ven
    INNER JOIN ventas ON detalle_ven.det_v_ven = ventas.idventas
    WHERE ventas.fec_ven BETWEEN fecha_inicio AND fecha_fin;

    RETURN IFNULL(total_ventas, 0);
END