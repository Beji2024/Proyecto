#language:es
#author: Breiner Rj
Característica: Registrar un nuevo proveedor
  Como administrador del sistema
  Quiero registrar un nuevo proveedor
  Para mantener actualizado el listado de proveedores

  @RegistrarProveedor
  Escenario: Registrar un proveedor exitosamente
    Dado que el administrador ingresa al módulo de proveedores con sus credenciales:
      | email            | password             |
      | felipe@gmail.com | skjdahkjshdu13432.,- |
    Cuando haga clic en el botón registrar proveedor
    Y complete el formulario con los siguientes datos:
      | nombre            | nit   | celular    | email                      | direccion |
      | Calzado Ejemplo 1 | 11221 | 3104567890 | calzado@calzadoejemplo.com | Calle 1   |
    Entonces se debe verificar que el proveedor haya sido registrado correctamente

