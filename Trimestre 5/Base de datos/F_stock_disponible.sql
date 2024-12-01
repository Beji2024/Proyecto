DELIMITER $$
CREATE DEFINER=`root`@`localhost` FUNCTION `F_stock_disponible`(id_pro INT)
 RETURNS int(11)
    DETERMINISTIC
BEGIN
 DECLARE stock INT;
 SELECT SUM(cantidad) INTO stock
 FROM mercancia m
 WHERE m.id_pro = id_pro
 GROUP BY m.id_pro;
 IF stock IS NULL THEN
   SET stock = 0;
 END IF;
RETURN stock;
END$$
DELIMITER ;