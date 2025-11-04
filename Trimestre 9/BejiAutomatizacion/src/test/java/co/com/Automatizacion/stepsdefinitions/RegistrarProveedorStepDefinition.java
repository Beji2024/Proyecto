package co.com.Automatizacion.stepsdefinitions;

import co.com.Automatizacion.models.Proveedor.DatosProveedor;
import co.com.Automatizacion.models.login.DatosLogin;
import co.com.Automatizacion.questions.Proveedor.ValidarInicio;
import co.com.Automatizacion.tasks.Proveedor.BTN_Registrar;
import co.com.Automatizacion.tasks.Proveedor.Formulario_Proveedor;
import co.com.Automatizacion.tasks.Proveedor.IrProveedor;
import co.com.Automatizacion.tasks.login.AbrirPagina;
import co.com.Automatizacion.tasks.login.Login;
import cucumber.api.java.es.*;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class RegistrarProveedorStepDefinition {

    @Dado("^que el administrador esté en la página de login$")
    public void queElAdministradorEsteEnLaPaginaDeLogin() {
        setTheStage(new OnlineCast());
        theActorCalled("Administrador").wasAbleTo(AbrirPagina.pagina());
    }

    @Cuando("^ingrese las credenciales:$")
    public void ingreseLasCredenciales(List<DatosLogin> datosLogin) {
        theActorInTheSpotlight().attemptsTo(Login.login(datosLogin));
    }
    @Entonces("^se debe verificar que el administrador haya ingresado correctamente al sistema$")
    public void seDebeVerificarElIngresoCorrecto() {
        theActorInTheSpotlight().should(seeThat(ValidarInicio.Ingreso()));
    }

    @Cuando("^se dirija al módulo de proveedores$")
    public void seDirijaAlModuloDeProveedores() {
        theActorInTheSpotlight().attemptsTo(IrProveedor.irProveedor());
    }

    @Cuando("^haga clic en el botón registrar proveedor$")
    public void hagaClicEnElBotonRegistrar() {
        theActorInTheSpotlight().attemptsTo(BTN_Registrar.btn_registrar());
    }

    @Cuando("^complete el formulario con los siguientes datos:$")
    public void completeElFormularioConLosSiguientesDatos(List<DatosProveedor> datos) {
        theActorInTheSpotlight().attemptsTo(Formulario_Proveedor.conDatos(datos));
    }

    @Entonces("^se debe verificar que el proveedor haya sido registrado correctamente$")
    public void seDebeVerificarQueElProveedorHayaSidoRegistradoCorrectamente() {
        // Aquí puedes agregar la validación del mensaje de éxito o la existencia del proveedor registrado
    }
}
