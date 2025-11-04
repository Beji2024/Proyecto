#language:es
#author: Breiner Rj

Característica: Gestionar proveedores en Sport10
  Como administrador del sistema Sport10
  Quiero iniciar sesión y registrar nuevos proveedores
  Para mantener actualizada la información en el sistema de inventario

  @LoginYProveedor
  Escenario: Inicio de sesión y registro exitoso de un nuevo proveedor
    Dado que el administrador esté en la página de login
    Cuando ingrese las credenciales:
      | email            | password       |
      | felipe@gmail.com | Br_23Kzn88Ql-1 |
    Entonces se debe verificar que el administrador haya ingresado correctamente al sistema

    Cuando se dirija al módulo de proveedores
    Y haga clic en el botón registrar proveedor
    Y complete el formulario con los siguientes datos:
      | nombre         | nit        | celular   | email                       | direccion               |
      | Calzado Nuevo  | 9601234567 | 3112223344 | contacto@calzadonuevo.com   | Calle 45 #10-22 Bogotá |
    Entonces se debe verificar que el proveedor haya sido registrado correctamente
