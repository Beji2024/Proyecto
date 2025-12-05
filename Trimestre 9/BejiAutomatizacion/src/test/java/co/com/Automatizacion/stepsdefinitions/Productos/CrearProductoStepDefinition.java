package co.com.Automatizacion.stepsdefinitions.Productos;

import co.com.Automatizacion.models.Producto.DatosProducto;
import co.com.Automatizacion.models.Usuarios.DatosLogin;
import co.com.Automatizacion.questions.Producto.ValidarCreacionProducto;
import co.com.Automatizacion.tasks.Producto.CrearProducto;
import co.com.Automatizacion.tasks.Producto.IngresarModuloProducto;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class CrearProductoStepDefinition {

    @Dado("^que el administrador esté en el módulo de productos con las credenciales:$")
    public void ingresarModuloProductos(List<DatosLogin> datosLogin) {
        setTheStage(new OnlineCast());
        theActorCalled("Administrador").attemptsTo(IngresarModuloProducto.con(datosLogin));
    }

    @Cuando("^el administrador cree un nuevo producto con los siguientes datos:$")
    public void crearNuevoProducto(List<DatosProducto>datos) {

        theActorInTheSpotlight().attemptsTo(CrearProducto.crearProducto(datos));
    }

    @Entonces("^el producto con debe aparecer en la lista de productos$")
    public void elProductoConDebeAparecerEnLaListaDeProductos() {
        theActorInTheSpotlight().should(seeThat(ValidarCreacionProducto.validarCreacionProducto()));
    }
}
