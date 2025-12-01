package co.com.Automatizacion.stepsdefinitions.venta;

import co.com.Automatizacion.interactions.AceptarAlerta;
import co.com.Automatizacion.tasks.venta.ClickEnDevoluciones;
import co.com.Automatizacion.tasks.venta.ClickEnVenta;
import co.com.Automatizacion.interactions.Esperar;
import cucumber.api.java.es.Cuando;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PaginaDevolucionesStepDefinition {

    @Cuando("el administrador ingresa al módulo de devoluciones")
    public void elAdministradorIngresaAlModuloDeDevoluciones() {
        theActorInTheSpotlight().attemptsTo(
                ClickEnVenta.ahora(),
                Esperar.segundos(2),
                ClickEnDevoluciones.ahora(),
                Esperar.segundos(1),
                AceptarAlerta.ahora()
        );
    }
}
