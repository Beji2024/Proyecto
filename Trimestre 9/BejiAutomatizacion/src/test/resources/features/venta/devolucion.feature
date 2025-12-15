#language: es
#author: Matrucs

Característica: Ingresar al módulo de Cambios en Sport10
  Como administrador de Sport10
  Quiero ingresar al módulo de Devoluciones
  Para continuar con el proceso correspondiente

  Antecedentes:
    Dado que el administrador esté en el módulo principal con las credenciales:
      | email            | password |
      | felipe@gmail.com | skjdahkjshdu13432.,-   |

  @Devolucion
  Escenario: devolucion de venta
    Cuando el administrador realiza la devolucion
    Entonces en el sistema se debe de poder visualizar el estado como Devolucion de dinero
    