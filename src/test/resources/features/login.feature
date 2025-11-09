#language:es
#author: Matrucs

Característica: Loguearse en la pagina Sport10
  Como administrador de la pagina Sport10
  Quiero loguearme con las credenciales asignadas
  Para tener acceso a las funciones de gestion de inventario y usuarios

  @Login
  Escenario: Validar el inicio de sesion exitoso
    Dado que el administrador este en la pagina
    Cuando ingrese las crendenciales para loguearse:
      | email                | password    |
      | bastar2909@gmail.com | matrucs2909 |
    Y el administrador hace click en Venta
    Y el administrador hace click en Consultar venta
    Y el administrador vuelve atras
    Y el administrador hace click en Crear venta
    Y el administrador llena el formulario de venta:
      | nombre_cli    | direccion_cli | correo_cli       | num_tel_cli | num_doc_cli | referencia | cantidad | vendedor |
      | Mateo Garcia  | Calle 123     | mateo@test.com   | 3015559999  | 123456789   | 1          | 2        | 20       |
    Entonces Se debe verificar que el administrador haya ingresado correctamente a la página y tenga acceso a sus funciones
