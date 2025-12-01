package co.com.Automatizacion.stepsdefinitions.Productos;

import co.com.Automatizacion.models.Producto.DatosProducto;
import co.com.Automatizacion.models.Usuarios.DatosLogin;
import co.com.Automatizacion.tasks.Producto.CrearProducto;
import co.com.Automatizacion.tasks.Producto.IngresarModuloProducto;
import cucumber.api.DataTable;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;
import java.util.Map;

import static co.com.Automatizacion.questions.Producto.ValidarCreacionProducto.esVisible;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class CrearProductoStepDefinition {

    @Dado("^que el administrador esté en el módulo de productos con las credenciales:$")
    public void ingresarModuloProductos(List<DatosLogin> datosLogin) {
        setTheStage(new OnlineCast());
        theActorCalled("Administrador").attemptsTo(IngresarModuloProducto.con(datosLogin));
    }

    @Cuando("^el administrador cree un nuevo producto con los siguientes datos:$")
    public void crearNuevoProducto(DataTable dataTable) {
        List<Map<String, String>> datos = dataTable.asMaps(String.class, String.class);
        Map<String, String> producto = datos.get(0);

        DatosProducto datosProducto = new DatosProducto(
                producto.get("nombre_producto"),
                producto.get("categoria"),
                producto.get("subcategoria"),
                producto.get("cantidad"),
                producto.get("talla"),
                producto.get("precio_venta"),
                producto.get("precio_compra"),
                producto.get("material"),
                producto.get("color"),
                producto.getOrDefault("imagen", "")
        );

        theActorInTheSpotlight().attemptsTo(CrearProducto.conLosDatos(datosProducto));
    }

    @Entonces("^el producto con nombre (.*) debe aparecer en la lista de productos$")
    public void verificarCreacionProducto(String nombreProducto) {
        theActorInTheSpotlight().should(seeThat(esVisible(nombreProducto)));
    }
}
