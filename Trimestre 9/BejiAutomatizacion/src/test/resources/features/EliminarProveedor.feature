#language: es
#author: Breiner Bj
Característica: Eliminar proveedor
  Como administrador del sistema
  Quiero eliminar un proveedor existente
  Para mantener la base de datos actualizada

  @EliminarProveedor
  Escenario: Eliminar proveedor exitosamente
    Dado que el administrador esté en el módulo de proveedores con las credenciales:
      | email            | password       |
      | felipe@gmail.com | Br_23Kzn88Ql-1 |
    Cuando el administrador elimine el proveedor con NIT 940345678
    Entonces el proveedor con NIT 940345678 no debe aparecer en la lista
