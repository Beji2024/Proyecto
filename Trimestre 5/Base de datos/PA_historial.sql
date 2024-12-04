DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_historial`(
    IN fecha_inicio DATE,
    IN fecha_fin DATE
)
BEGIN
    DECLARE total_gastado DOUBLE DEFAULT 0;
    DECLARE total_vendido DOUBLE DEFAULT 0;
    DECLARE ganancias DOUBLE DEFAULT 0;
    
    SELECT IFNULL(SUM(dp.precio_tt), 0) 
    INTO total_gastado
    FROM pedido p
    JOIN detalle_ped dp ON p.idpedido = dp.det_p_ped
    WHERE p.fec_ped BETWEEN fecha_inicio AND fecha_fin;
    
    SELECT IFNULL(SUM(dv.precio_tt), 0) 
    INTO total_vendido
    FROM ventas v
    JOIN detalle_ven dv ON v.idventas = dv.id_detven
    WHERE v.fec_ven BETWEEN fecha_inicio AND fecha_fin;
    
    IF total_gastado <= total_vendido THEN
        SET ganancias = total_vendido-total_gastado;
        SELECT total_gastado AS Total_Gastado, total_vendido AS Total_Vendido, ganancias AS Ganancia;
    ELSE
        SET ganancias = total_gastado - total_vendido;
        SELECT total_gastado AS Total_Gastado, total_vendido AS Total_Vendido, ganancias AS Pedida;
    END IF;
END $$

DELIMITER 