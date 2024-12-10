CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_stock_producto`(
    IN p_id_pro INT,
    IN p_cantidad INT
)
BEGIN
    UPDATE mercancia
    SET cantidad = p_cantidad
    WHERE id_pro = p_id_pro;
END