CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_realizar_pedido`(
    IN fec_ped DATE,        
    IN ped_prov INT,       
    IN ped_user INT,  
    IN productos JSON      
)
BEGIN
    DECLARE idpedido INT;
    DECLARE idpro INT;
    DECLARE cant INT;
    DECLARE iterador INT DEFAULT 0;
    DECLARE num_productos INT;
    DECLARE proveedor_existe INT;
    
    SELECT COUNT(*) INTO proveedor_existe
    FROM proveedores
    WHERE nit = ped_prov;
    
    IF proveedor_existe = 0 THEN
		SELECT '¡Atención! El proveedor con el ID proporcionado no existe' AS mensaje_alerta;
    ELSE
    INSERT INTO pedido (fec_ped, ped_prov, ped_user, ped_est)
    VALUES (fec_ped, ped_prov, ped_user, 1); 

    SET idpedido = LAST_INSERT_ID();
    SET num_productos = JSON_LENGTH(productos);

    WHILE iterador < num_productos DO

        SET idpro = JSON_UNQUOTE(JSON_EXTRACT(productos, CONCAT('$[', iterador, '].id_pro')));
        SET cant = JSON_UNQUOTE(JSON_EXTRACT(productos, CONCAT('$[', iterador, '].cantidad')));

        INSERT INTO detalle_ped (cantidad, det_p_mer, det_p_ped, precio_uni, precio_tt)
        SELECT cant, id_pro, idpedido, m.precio_compra, m.precio_compra * cant
        FROM mercancia m WHERE m.id_pro = idpro;
        SET iterador = iterador + 1;
    END WHILE;
    END IF;
END