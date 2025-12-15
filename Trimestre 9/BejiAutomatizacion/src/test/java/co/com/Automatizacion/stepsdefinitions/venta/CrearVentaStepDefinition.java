package co.com.Automatizacion.stepsdefinitions.venta;


import co.com.Automatizacion.models.Usuarios.DatosLogin;
import co.com.Automatizacion.models.Venta.Ventas;
import co.com.Automatizacion.questions.Venta.ValidarCreacionVenta;
import co.com.Automatizacion.tasks.venta.CrearVenta;
import co.com.Automatizacion.tasks.venta.IngresarModuloVenta;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class CrearVentaStepDefinition {

    @Dado("^que el administrador esté en el módulo de ventas con las credenciales:$")
    public void ingresarModuloVentas(List<DatosLogin> credenciales) {

        setTheStage(new OnlineCast());
        theActorCalled("Administrador").attemptsTo(IngresarModuloVenta.con(credenciales));
    }

    @Cuando("^el administrador este en el modulo de venta debe registrar una venta con los siguientes datos:$")
    public void registrarVenta(List<Ventas> datos) {

        theActorInTheSpotlight().attemptsTo(CrearVenta.con(datos));
    }

    @Entonces("^la venta debe quedar registrada correctamente$")
    public void validarVentaRegistrada() {

        theActorInTheSpotlight().should(seeThat(ValidarCreacionVenta.esExitosa()));
    }
}
