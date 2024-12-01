DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_productos_nuevos`(
     IN id_mer INT,         
    IN cant TINYINT,       
    IN id_user INT,         
    IN nit INT              
)
BEGIN
    DECLARE fecha_actual DATETIME;
    DECLARE producto_existe int;
    SET fecha_actual = NOW();  
    
	SELECT COUNT(*) INTO producto_existe
    FROM mercancia
    WHERE id_pro = id_mer;
    
    IF producto_existe = 0 THEN
		SELECT '¡Atención! El producto con el ID proporcionado no existe' AS mensaje_alerta;
    ELSE
    INSERT INTO registro_inventario (fec_ing, id_user) 
    VALUES (fecha_actual, id_user);

    INSERT INTO detalle_reg (cantidad, det_mer, det_reginv, det_prov) 
    VALUES (cant, id_mer, LAST_INSERT_ID(), nit);

	UPDATE mercancia
    SET cantidad = cantidad + cant
    WHERE id_pro = id_mer;
    END IF;
END $$
DELIMITER ;