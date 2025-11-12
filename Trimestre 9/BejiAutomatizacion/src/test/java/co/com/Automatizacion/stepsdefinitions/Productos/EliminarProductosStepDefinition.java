package co.com.Automatizacion.stepsdefinitions.Productos;

import co.com.Automatizacion.models.Usuarios.DatosLogin;
import co.com.Automatizacion.tasks.Producto.EliminarProducto;
import co.com.Automatizacion.tasks.Producto.IngresarModuloProducto;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

import static co.com.Automatizacion.questions.Producto.ValidarEliminacionProducto.noExiste;
import static co.com.Automatizacion.tasks.Producto.EliminarProducto.nombreProductoEliminado;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class EliminarProductosStepDefinition {

    @Dado("^que el administrador esté en el módulo de productos con la credenciales:$")
    public void ingresarModuloProductos(List<DatosLogin> datosLogin) {
        setTheStage(new OnlineCast());
        theActorCalled("Administrador").attemptsTo(IngresarModuloProducto.con(datosLogin));
    }

    @Cuando("^el administrador elimine el último producto de la lista$")
    public void eliminarUltimoProducto() {
        theActorInTheSpotlight().attemptsTo(EliminarProducto.delListado());
    }

    @Entonces("^el producto debe desaparecer de la lista de productos$")
    public void verificarEliminacionProducto() {
        theActorInTheSpotlight().should(seeThat(noExiste(nombreProductoEliminado)));
    }
}

