package co.com.Automatizacion.stepsdefinitions.venta;

import co.com.Automatizacion.interactions.Esperar;
import co.com.Automatizacion.tasks.venta.*;
import co.com.Automatizacion.userinterface.venta.ClickEnConsultarVenta;
import cucumber.api.java.es.Cuando;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PaginaCambiosStepDefinition {

    @Cuando("el administrador ingresa al módulo de cambios")
    public void elAdministradorIngresaAlModuloCambios() {
        theActorInTheSpotlight().attemptsTo(
                ClickEnVenta.ahora(),
                Esperar.segundos(3)
        );
    }

    @Cuando("el administrador hace clic en el botón Cambios")
    public void elAdministradorHaceClicEnElBotonCambios() {
        theActorInTheSpotlight().attemptsTo(
                ClickEnBotonCambios.ahora(),
                Esperar.segundos(3)
        );
    }
    @Cuando("el administrador realiza un cambio en una venta")
    public void elAdministradorRealizaUnCambio() {
        theActorInTheSpotlight().attemptsTo(
                ClickEnRealizarCambio.ahora(),
                Esperar.segundos(2)
        );
    }




}
