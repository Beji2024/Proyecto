CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_insertar_proveedores`( IN p_nit INT,
    IN p_nombre VARCHAR(50),
    IN p_direccion VARCHAR(40),
    IN p_telefono VARCHAR(20),
    IN p_correo blob,
    IN p_precio double
)
BEGIN
    INSERT INTO proveedores (nit, nombre, direccion, telefono, correo,precio)
    VALUES (p_nit, p_nombre, p_direccion, p_telefono, p_correo,p_precio);
    insert into proveedores 
    values('mateogarcia','calle45','3123351988', aes_encrypt('bastar2909@gmail.com','perri'));
    
    select * from proveedores
END