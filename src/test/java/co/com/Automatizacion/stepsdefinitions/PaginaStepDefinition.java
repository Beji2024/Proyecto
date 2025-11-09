package co.com.Automatizacion.stepsdefinitions;

import co.com.Automatizacion.tasks.login.ClickEnVenta;

import co.com.Automatizacion.tasks.login.task.ClickCrearVenta;
import co.com.Automatizacion.tasks.login.task.LlenarFormularioVenta;
import co.com.Automatizacion.userinterface.login.venta.ClickEnConsultarVenta;
import co.com.Automatizacion.tasks.login.task.Esperar;
import co.com.Automatizacion.tasks.login.task.VolverAtras;
import cucumber.api.DataTable;
import cucumber.api.java.es.Cuando;
import net.serenitybdd.screenplay.actors.OnStage;



import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PaginaStepDefinition {

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
                Esperar.segundos(10)

        );
    }

    @Cuando("el administrador vuelve atras")
    public void elAdministradorVuelveAtras() {
        theActorInTheSpotlight().attemptsTo(
                VolverAtras.ahora(),
                Esperar.segundos(5)
        );
    }

    @Cuando("el administrador hace click en Crear venta")
    public void elAdministradorHaceClickEnCrearVenta() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClickCrearVenta.ahora(),
                Esperar.segundos(5)
        );
    }

    @Cuando("el administrador llena el formulario de venta:")
    public void elAdministradorLlenaElFormularioDeVenta(DataTable dataTable) {

        Map<String, String> datos = dataTable.asMaps(String.class, String.class).get(0);

        OnStage.theActorInTheSpotlight().attemptsTo(
                LlenarFormularioVenta.conDatos(
                        datos.get("nombre_cli"),
                        datos.get("direccion_cli"),
                        datos.get("correo_cli"),
                        datos.get("num_tel_cli"),
                        datos.get("num_doc_cli"),
                        datos.get("referencia"),
                        datos.get("cantidad"),
                        datos.get("vendedor")
                )
        );
    }










}
