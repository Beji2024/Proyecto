CREATE DEFINER=`root`@`localhost` FUNCTION `ventas_por_cliente`(id_usuario INT) RETURNS decimal(10,2)
    DETERMINISTIC
BEGIN
    DECLARE monto_total DECIMAL(10,2);

    SELECT SUM(detalle_ven.precio_tt) INTO monto_total
    FROM detalle_ven
    INNER JOIN ventas ON detalle_ven.det_v_ven = ventas.idventas
    WHERE ventas.ven_usu = id_usuario;

    RETURN monto_total;
END