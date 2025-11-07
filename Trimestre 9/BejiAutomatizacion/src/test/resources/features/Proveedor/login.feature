#language:es
  #author: Felipe Mosquera

  Característica: Loguearse en la pagina Sport10
    Como administrador de la pagina Sport10
    Quiero loguearme con las credenciales asignadas
    Para tener acceso a las funciones de gestion de inventario y usuarios

    @Login

    Escenario: Validar el inicio de sesion exitoso
      Dado que el administrador este en la pagina
      Cuando ingrese las crendenciales para loguearse:
        | email            | password |
        | felipe@gmail.com | 123456   |
      Entonces Se debe verificar que el administrador haya ingresado correctamente a la página y tenga acceso a sus funciones


