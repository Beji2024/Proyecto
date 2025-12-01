package co.com.Automatizacion.stepsdefinitions.venta;

import co.com.Automatizacion.interactions.Esperar;
import co.com.Automatizacion.questions.Venta.Elemento;
import co.com.Automatizacion.tasks.venta.ClickCrearVenta;
import co.com.Automatizacion.tasks.venta.LlenarFormularioVenta;
import co.com.Automatizacion.userinterface.venta.FormularioVenta;
import cucumber.api.DataTable;
import cucumber.api.java.es.Cuando;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PaginaCrearVentaStepDefinition {

    @Cuando("el administrador hace click en Crear venta")
    public void elAdministradorHaceClickEnCrearVenta() {
        theActorInTheSpotlight().attemptsTo(
                ClickCrearVenta.ahora(),
                Esperar.segundos(4)
        );
    }

    @Cuando("el administrador llena el formulario de venta:")
    public void elAdministradorLlenaElFormularioDeVenta(DataTable dataTable) {

        Map<String, String> datos = dataTable.asMaps(String.class, String.class).get(0);

        theActorInTheSpotlight().attemptsTo(
                LlenarFormularioVenta.conDatos(
                        datos.get("nombre_cli"),
                        datos.get("direccion_cli"),
                        datos.get("correo_cli"),
                        datos.get("num_tel_cli"),
                        datos.get("num_doc_cli"),
                        datos.get("referencia"),
                        datos.get("cantidad"),
                        datos.get("vendedor")
                ),
                Esperar.segundos(3)
        );
    }


}
