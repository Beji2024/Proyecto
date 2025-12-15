package co.com.Automatizacion.stepsdefinitions.venta;

import co.com.Automatizacion.models.Usuarios.DatosLogin;
import co.com.Automatizacion.questions.Venta.ValidarDevolucion;
import co.com.Automatizacion.tasks.venta.IngresarModuloVenta;
import co.com.Automatizacion.tasks.venta.RealizarDevolucion;
import cucumber.api.PendingException;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class DevolucionVentaStepDefinition {

    @Dado("^que el administrador esté en el módulo principal con las credenciales:$")
    public void queElAdministradorEsteEnElModuloDeVentasConLasCredenciales(List<DatosLogin> credenciales) {

        setTheStage(new OnlineCast());
        theActorCalled("Administrador").attemptsTo(IngresarModuloVenta.con(credenciales));
    }


    @Cuando("^el administrador realiza la devolucion$")
    public void elAdministradorRealizaLaDevolucion() {
        theActorCalled("Administrador").attemptsTo(
                RealizarDevolucion.realizar()
        );
    }


    @Entonces("^en el sistema se debe de poder visualizar el estado como Devolucion de dinero$")
    public void enElSistemaSeDebeDePoderVisualizarElEstadoComoDevolucionDeDinero() {

        theActorCalled("Administrador").should(
                seeThat(ValidarDevolucion.fueExitosa())
        );
    }




}
