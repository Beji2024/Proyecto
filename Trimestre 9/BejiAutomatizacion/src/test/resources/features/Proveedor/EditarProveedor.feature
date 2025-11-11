# language: es
# Breiner Bj
Característica: Editar proveedor existente
  Como administrador del sistema
  Quiero editar un proveedor existente
  Para actualizar su información en el sistema

  @EditarProveedor
  Escenario: Editar un proveedor exitosamente
    Dado que el administrador haya accedido al módulo de proveedores con las credenciales:
      | email            | password       |
      | felipe@gmail.com | skjdahkjshdu13432.,- |
    Cuando el administrador edite el proveedor con NIT 9701234567 con los siguientes datos:
      | celular    | email                           | direccion          |
      | 3115557788 | contacto@calzadosdeportivos.com | Av. 9 #100-99 Cali |
    Entonces se debe verificar que el proveedor haya sido actualizado correctamente
