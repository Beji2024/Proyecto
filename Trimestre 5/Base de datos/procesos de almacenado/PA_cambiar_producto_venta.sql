CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_cambiar_producto_venta`(
    IN p_id_detven INT,            
    IN p_nuevo_producto INT,      
    IN p_nueva_cantidad INT       
)
BEGIN
    DECLARE producto_anterior INT;
    DECLARE cantidad_anterior INT;

    -- Obtener el producto anterior y su cantidad
    SELECT det_v_mer, cantidad 
    INTO producto_anterior, cantidad_anterior
    FROM detalle_ven
    WHERE id_detven = p_id_detven;

    -- Actualizar la cantidad anterior en el inventario
    UPDATE mercancia
    SET cantidad = cantidad + cantidad_anterior
    WHERE id_pro = producto_anterior;

    -- Actualizar la venta con el nuevo producto y cantidad
    UPDATE detalle_ven
    SET det_v_mer = p_nuevo_producto,
        cantidad = p_nueva_cantidad,
        precio_uni = (SELECT precio_venta FROM mercancia WHERE id_pro = p_nuevo_producto),
        precio_tt = (SELECT precio_venta FROM mercancia WHERE id_pro = p_nuevo_producto) * p_nueva_cantidad
    WHERE id_detven = p_id_detven;
END