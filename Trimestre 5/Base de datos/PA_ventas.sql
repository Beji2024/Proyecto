DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_ventas`(
    IN fec_ven DATE,        
    IN nom_com VARCHAR(50),  
    IN correo VARCHAR(45),   
    IN telefono VARCHAR(20), 
    IN direccion VARCHAR(45), 
    IN ven_usu INT,         
    IN productos JSON    
)
BEGIN
    DECLARE idventa INT;
    DECLARE idpro INT;
    DECLARE _cantidad INT;
    DECLARE precio DOUBLE;
    DECLARE iterador INT DEFAULT 0;
    DECLARE num_productos INT;
    DECLARE cantidad_disponible INT;
    DECLARE _umbral INT DEFAULT 10; 
    DECLARE nombre_producto VARCHAR(255);

    SET num_productos = JSON_LENGTH(productos);

    WHILE iterador < num_productos DO
        SET idpro = JSON_UNQUOTE(JSON_EXTRACT(productos, CONCAT('$[', iterador, '].id_pro')));
        SET _cantidad = JSON_UNQUOTE(JSON_EXTRACT(productos, CONCAT('$[', iterador, '].cantidad')));

        SELECT cantidad INTO cantidad_disponible 
        FROM mercancia 
        WHERE id_pro = idpro
        LIMIT 1;  

        SELECT precio_venta INTO precio
        FROM mercancia 
        WHERE id_pro = idpro
        LIMIT 1; 

        IF cantidad_disponible >= _cantidad THEN
			INSERT INTO ventas (fec_ven, nom_com, correo, telefono, direccion, ven_usu) 
            VALUES (fec_ven, nom_com, correo, telefono, direccion, ven_usu);
            SET idventa = LAST_INSERT_ID();
            INSERT INTO detalle_ven (cantidad, precio_uni, precio_tt, det_v_ven, det_v_mer) 
            VALUES (_cantidad, precio, precio * _cantidad, idventa, idpro);
            
            UPDATE mercancia
            SET cantidad = cantidad - _cantidad
            WHERE id_pro = idpro;
            
        ELSE
            INSERT INTO alertas_inventario (idpro, nombre_producto, cantidad_restante, mensaje) 
            VALUES (idpro, nombre_producto, cantidad_disponible,
            CONCAT('¡Atención! No hay suficiente stock para el producto "', nombre_producto, '". Solo quedan ', cantidad_disponible, ' unidades.'));
        END IF;
        SET iterador = iterador + 1;
    END WHILE;
END$$
DELIMITER ;