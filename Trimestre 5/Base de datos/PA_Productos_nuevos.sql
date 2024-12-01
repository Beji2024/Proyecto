DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_productos_nuevos`(
    IN id_mer INT,         
    IN cant TINYINT,       
    IN id_user INT,         
    IN nit INT              
)
BEGIN
    DECLARE fecha_actual DATETIME;
    SET fecha_actual = NOW();  

    INSERT INTO registro_inventario (fec_ing, id_user) 
    VALUES (fecha_actual, id_user);

    INSERT INTO detalle_reg (cantidad, det_mer, det_reginv, det_prov) 
    VALUES (cant, id_mer, LAST_INSERT_ID(), nit);

	UPDATE mercancia
    SET cantidad = cantidad + cant
    WHERE id_pro = id_mer;
END
$$
DELIMITER ;