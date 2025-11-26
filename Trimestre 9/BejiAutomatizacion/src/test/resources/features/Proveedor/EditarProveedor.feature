# language: es
# author: Breiner Bj

Característica: Editar proveedor existente
  Como administrador del sistema
  Quiero editar un proveedor existente
  Para actualizar su información en el sistema

  Antecedentes:
    Dado que el administrador haya accedido al módulo de proveedores con las credenciales:
      | email            | password       |
      | felipe@gmail.com | skjdahkjshdu13432.,- |
    Entonces se debe verificar que el administrador haya ingresado correctamente y tenga acceso a sus funciones

  @EditarProveedor
  Escenario: Editar un proveedor exitosamente
    Dado que el administrador se encuentre en el módulo de proveedores para editar
    Cuando el administrador edite un proveedor con los siguientes datos:
      | celular    | email                           | direccion |
      | 3115557788 | contacto@calzadosdeportivos.com | Av. 9 #   |
    Entonces se debe verificar que el proveedor haya sido actualizado correctamente
