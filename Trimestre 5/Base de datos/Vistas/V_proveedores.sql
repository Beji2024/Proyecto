CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `vista_proveedores` AS
    SELECT 
        `p`.`nit` AS `nit`,
        `p`.`nombre` AS `nombre`,
        `p`.`precio` AS `precio`,
        `p`.`direccion` AS `direccion`,
        `p`.`telefono` AS `telefono`,
        `p`.`correo` AS `correo`
    FROM
        `proveedores` `p`