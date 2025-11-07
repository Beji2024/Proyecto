#language:es
#author: Breiner Rj
Característica: Registrar un nuevo proveedor
  Como administrador del sistema
  Quiero registrar un nuevo proveedor
  Para mantener actualizado el listado de proveedores

  @RegistrarProveedor
  Escenario: Registrar un proveedor exitosamente
    Dado que el administrador ingresa al módulo de proveedores con sus credenciales:
      | email            | password           |
      | felipe@gmail.com | Br_23Kzn88Ql-1 |
    Cuando haga clic en el botón registrar proveedor
    Y complete el formulario con los siguientes datos:
      | nombre             | nit        | celular     | email                       | direccion             |
      | Calzado Ejemplo SAS| 9701234567 | 3104567890  | ventas@calzadoejemplo.com   | Calle 99 #88-77 Cali |
    Entonces se debe verificar que el proveedor haya sido registrado correctamente

