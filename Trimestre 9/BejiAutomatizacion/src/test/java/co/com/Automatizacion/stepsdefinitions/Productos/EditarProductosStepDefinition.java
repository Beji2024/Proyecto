package co.com.Automatizacion.stepsdefinitions.Productos;

import co.com.Automatizacion.models.Producto.DatosProducto;
import co.com.Automatizacion.models.Usuarios.DatosLogin;
import co.com.Automatizacion.tasks.Producto.EditarProducto;
import co.com.Automatizacion.tasks.Producto.IngresarModuloProducto;
import cucumber.api.DataTable;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;
import java.util.Map;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class EditarProductosStepDefinition {

    @Dado("^que el administrador esté en el módulo de productos las credenciales:$")
    public void ingresarModuloProductos(List<DatosLogin> datosLogin) {
        setTheStage(new OnlineCast());
        theActorCalled("Administrador").attemptsTo(IngresarModuloProducto.con(datosLogin));
    }

    @Cuando("^el administrador edite el último producto con los siguientes datos:$")
    public void editarUltimoProducto(DataTable dataTable) {
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

        theActorInTheSpotlight().attemptsTo(EditarProducto.conLosDatos(datosProducto));
    }

    @Cuando("^presione el botón \"Actualizar\"$")
    public void presioneActualizar() {

    }

    @Entonces("^el producto editado debe mostrarse correctamente actualizado en la lista de productos$")
    public void verificarEdicionProducto() {

    }
}
