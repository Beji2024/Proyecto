CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `vista_ventas_realizadas` AS
    SELECT 
        `v`.`idventas` AS `idventas`,
        `v`.`fec_ven` AS `fec_ven`,
        `v`.`nom_com` AS `nom_com`,
        `v`.`correo` AS `correo`,
        `v`.`telefono` AS `telefono`,
        `v`.`direccion` AS `direccion`,
        `dv`.`det_v_mer` AS `det_v_mer`,
        `dv`.`cantidad` AS `cantidad`,
        `dv`.`precio_uni` AS `precio_uni`,
        `dv`.`precio_tt` AS `precio_tt`
    FROM
        (`ventas` `v`
        JOIN `detalle_ven` `dv` ON (`v`.`idventas` = `dv`.`det_v_ven`))