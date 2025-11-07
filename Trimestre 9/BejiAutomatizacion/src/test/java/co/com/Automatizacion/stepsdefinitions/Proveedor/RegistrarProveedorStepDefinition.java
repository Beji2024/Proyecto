package co.com.Automatizacion.stepsdefinitions.Proveedor;

import co.com.Automatizacion.models.Proveedor.DatosProveedor;
import co.com.Automatizacion.models.Usuarios.DatosLogin;
import co.com.Automatizacion.questions.Proveedor.ValidarRegistroProveedor;
import co.com.Automatizacion.tasks.Proveedor.*;
import cucumber.api.java.es.*;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

import static co.com.Automatizacion.questions.Proveedor.ValidarEdicionProveedor.tituloVisible;
import static co.com.Automatizacion.questions.Proveedor.ValidarRegistroProveedor.conNombre;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class RegistrarProveedorStepDefinition {
    private String nombreProveedorRegistrado;

    @Dado("^que el administrador ingresa al módulo de proveedores con sus credenciales:$")
    public void ingresarAlModuloDeProveedores(List<DatosLogin> datosLogin) {
        setTheStage(new OnlineCast());
        theActorCalled("Administrador").attemptsTo(
                IngresarModuloProveedor.con(datosLogin)
        );
    }

    @Cuando("^haga clic en el botón registrar proveedor$")
    public void clicEnRegistrar() {
        theActorInTheSpotlight().attemptsTo(BTN_Registrar.btn_registrar());
    }

    @Cuando("^complete el formulario con los siguientes datos:$")
    public void llenarFormulario(List<DatosProveedor> datos) {
        nombreProveedorRegistrado = datos.get(0).getNombre();
        theActorInTheSpotlight().attemptsTo(Formulario_Proveedor.conDatos(datos));
    }

    @Entonces("^se debe verificar que el proveedor haya sido registrado correctamente$")
    public void seDebeVerificarQueElProveedorHayaSidoRegistradoCorrectamente() {
        theActorInTheSpotlight().should(seeThat(conNombre(nombreProveedorRegistrado)));
    }
}

