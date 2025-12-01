package co.com.Automatizacion.stepsdefinitions.venta;

import co.com.Automatizacion.interactions.Esperar;
import co.com.Automatizacion.tasks.venta.ClickEnVenta;
import co.com.Automatizacion.userinterface.venta.ClickEnConsultarVenta;
import co.com.Automatizacion.tasks.venta.VolverAtras;
import co.com.Automatizacion.tasks.venta.ClickEnImagenVentaTask;
import cucumber.api.java.es.Cuando;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PaginaConsultarVentaStepDefinition {

    @Cuando("el administrador hace click en Venta")
    public void elAdministradorHaceClickEnVenta() {
        theActorInTheSpotlight().attemptsTo(
                ClickEnVenta.ahora()
        );
    }


    @Cuando("el administrador hace click en Consultar venta")
    public void elAdministradorHaceClickEnConsultarVenta() {
        theActorInTheSpotlight().attemptsTo(
                ClickEnConsultarVenta.ahora(),
                Esperar.segundos(5)
        );
    }

    @Cuando("el administrador vuelve atras")
    public void elAdministradorVuelveAtras() {
        theActorInTheSpotlight().attemptsTo(
                VolverAtras.ahora(),
                Esperar.segundos(3)
        );
    }

    @Cuando("el administrador vuelve a consultar venta")
    public void elAdministradorVuelveAConsultarVenta() {
        theActorInTheSpotlight().attemptsTo(
                ClickEnConsultarVenta.ahora(),
                Esperar.segundos(2),
                VolverAtras.ahora(),
                Esperar.segundos(2)
        );
    }

    @Cuando("el administrador hace click en la imagen de venta")
    public void elAdministradorHaceClickEnLaImagenDeVenta() {
        theActorInTheSpotlight().attemptsTo(
                ClickEnImagenVentaTask.ahora(),
                Esperar.segundos(3)
        );
    }
}
