#language: es
#author: Breiner Bj

Característica: Eliminar un proveedor en la página web de Sport10
  Como administrador de la página web
  Quiero registrar proveedores en la página web
  Para dejar registro de los proveedores que desee

  Antecedentes:
    Dado que el administrador esté en la página
    Cuando ingrese las credenciales para loguearse:
      | email            | password       |
      | felipe@gmail.com | Br_23Kzn88Ql-1 |

  @EliminarProveedor
  Escenario: Verificar que se elimina el proveedor
    Dado que el administrador se encuentre en la página en el módulo de proveedores
    Y exista un proveedor registrado con NIT "9601234567"
    Cuando dé en el botón de eliminar y confirme la acción
    Entonces se debe verificar que el proveedor con NIT "9601234567" se haya eliminado de la página web
