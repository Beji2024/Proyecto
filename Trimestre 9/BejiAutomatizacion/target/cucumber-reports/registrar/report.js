$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/RegistrarProveedor.feature");
formatter.feature({
  "name": "Registrar un nuevo proveedor",
  "description": "  Como administrador del sistema\n  Quiero registrar un nuevo proveedor\n  Para mantener actualizado el listado de proveedores",
  "keyword": "Característica"
});
formatter.scenario({
  "name": "Registrar un proveedor exitosamente",
  "description": "",
  "keyword": "Escenario",
  "tags": [
    {
      "name": "@RegistrarProveedor"
    }
  ]
});
formatter.step({
  "name": "que el administrador ingresa al módulo de proveedores con sus credenciales:",
  "rows": [
    {
      "cells": [
        "email",
        "password"
      ]
    },
    {
      "cells": [
        "felipe@gmail.com",
        "Br_23Kzn88Ql-1"
      ]
    }
  ],
  "keyword": "Dado "
});
formatter.match({
  "location": "RegistrarProveedorStepDefinition.ingresarAlModuloDeProveedores(DatosLogin\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "haga clic en el botón registrar proveedor",
  "keyword": "Cuando "
});
formatter.match({
  "location": "RegistrarProveedorStepDefinition.clicEnRegistrar()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "complete el formulario con los siguientes datos:",
  "rows": [
    {
      "cells": [
        "nombre",
        "nit",
        "celular",
        "email",
        "direccion"
      ]
    },
    {
      "cells": [
        "Calzado Ejemplo SAS",
        "9701234567",
        "3104567890",
        "ventas@calzadoejemplo.com",
        "Calle 99 #88-77 Cali"
      ]
    }
  ],
  "keyword": "Y "
});
formatter.match({
  "location": "RegistrarProveedorStepDefinition.llenarFormulario(DatosProveedor\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "se debe verificar que el proveedor haya sido registrado correctamente",
  "keyword": "Entonces "
});
formatter.match({
  "location": "RegistrarProveedorStepDefinition.seDebeVerificarQueElProveedorHayaSidoRegistradoCorrectamente()"
});
formatter.result({
  "status": "passed"
});
});