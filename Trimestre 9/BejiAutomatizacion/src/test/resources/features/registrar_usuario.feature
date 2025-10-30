  #language:es
  #author: Felipe Mosquera

Característica: Registrar un usuario en pagina web de Sport10
  Como administrador de la pagina web
  Quiero registrar usuarios en la pagina web
  Para Dejar registro de los usuarios que desee

  @RegistrarUsuarios

  Escenario: Verificar el registro exitoso de un nuevo usuario
    Dado que el usuario se encuentre en la pagina de pruebas en el modulo de usuarios
    Cuando ingresa los datos necesarios para el registro del usuario:
      | num_doc   | nombres | apellidos | direccion   | email            | num_tel    | fec_nac    | password |
      | 111222333 | Pepito  | Perez     | Cl 34 #32-2 | pepito@gmail.com | 3334445553 | 10-10-2025 | 123456   |

    Entonces Se debe verificar que el usuario este registrado en la seccion de registros





