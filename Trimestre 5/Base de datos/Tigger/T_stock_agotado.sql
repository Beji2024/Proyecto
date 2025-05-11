DELIMITER $$
CREATE TRIGGER T_stock_agotado
AFTER UPDATE ON mercancia
FOR EACH ROW
BEGIN
DECLARE umbral INT DEFAULT 10;
-- Verificar si la cantidad de un producto es menor o igual al umbral
IF NEW.cantidad <= umbral THEN
INSERT INTO alertas_inventario (id_pro, nombre_producto, cantidad_restante, mensaje)VALUES (NEW.id_pro, NEW.nombre, NEW.cantidad, 
CONCAT('¡Atención! El producto "', NEW.nombre, '" está a punto de agotarse. Solo quedan ', NEW.cantidad, ' unidades.'));
END IF;
END$$
DELIMITER ;

