$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/Proveedor/RegistrarProveedor.feature");
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
        "skjdahkjshdu13432.,-"
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
  "error_message": "java.lang.AssertionError: unknown error: Call WaitForPendingNavigations only on the parent WebView\n  (Session info: chrome\u003d142.0.7444.61)\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027CALLCENTER-060\u0027, ip: \u0027192.168.112.18\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u002715.0.2\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 142.0.7444.61, chrome: {chromedriverVersion: 142.0.7444.59 (4b8153ab58d3..., userDataDir: C:\\Users\\APREND~1.SEN\\AppDa...}, fedcm:accounts: true, goog:chromeOptions: {debuggerAddress: localhost:53379}, goog:processID: 19804, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: ignore, webauthn:extension:credBlob: true, webauthn:extension:largeBlob: true, webauthn:extension:minPinLength: true, webauthn:extension:prf: true, webauthn:virtualAuthenticators: true}\nSession ID: 1a5c2cda92461eaed975633167f26275\n*** Element info: {Using\u003dcss selector, value\u003dtable.table}\r\n\tat net.serenitybdd.screenplay.ErrorTally.throwSummaryExceptionFrom(ErrorTally.java:36)\r\n\tat net.serenitybdd.screenplay.ErrorTally.reportAnyErrors(ErrorTally.java:30)\r\n\tat net.serenitybdd.screenplay.Actor.should(Actor.java:316)\r\n\tat co.com.Automatizacion.stepsdefinitions.Proveedor.RegistrarProveedorStepDefinition.seDebeVerificarQueElProveedorHayaSidoRegistradoCorrectamente(RegistrarProveedorStepDefinition.java:41)\r\n\tat ✽.se debe verificar que el proveedor haya sido registrado correctamente(src/test/resources/features/Proveedor/RegistrarProveedor.feature:17)\r\n",
  "status": "failed"
});
});