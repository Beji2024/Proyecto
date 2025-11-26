#language: es
#author: Breiner Bj
Característica: Eliminar proveedor aleatorio
  Como administrador del sistema
  Quiero eliminar un proveedor existente de forma aleatoria
  Para mantener la base de datos actualizada

  @EliminarProveedorAleatorio
  Escenario: El administrador elimina un proveedor aleatorio
    Dado que el administrador esté en el módulo de proveedores con las credenciales:
      | email            | password       |
      | felipe@gmail.com | skjdahkjshdu13432.,- |
    Cuando el administrador elimine un proveedor aleatorio
    Entonces el proveedor eliminado no debe aparecer en la lista
