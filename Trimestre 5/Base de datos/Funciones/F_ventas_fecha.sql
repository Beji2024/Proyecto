CREATE DEFINER=`root`@`localhost` FUNCTION `ventas_fecha`(fecha_venta DATE) RETURNS int(11)
    DETERMINISTIC
BEGIN
DECLARE cantidad_vendida_total INT;

    SELECT SUM(cantidad) INTO cantidad_vendida_total
    FROM detalle_ven d
    INNER JOIN ventas v ON d.det_v_ven = v.idventas
    WHERE v.fec_ven = fecha_venta;

    RETURN cantidad_vendida_total;
END