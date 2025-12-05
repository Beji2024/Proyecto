package co.com.Automatizacion.stepsdefinitions.Productos;

import co.com.Automatizacion.models.Producto.DatosProducto;
import co.com.Automatizacion.models.Usuarios.DatosLogin;
import co.com.Automatizacion.questions.Producto.ValidarCreacionProducto;
import co.com.Automatizacion.questions.Producto.ValidarEditarProducto;
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
    public void editarUltimoProducto(List<DatosProducto>datos) {
        theActorInTheSpotlight().attemptsTo(EditarProducto.editarProducto(datos));

    }


    @Entonces("^el producto editado debe mostrarse correctamente actualizado en la lista de productos$")
    public void verificarEdicionProducto() {
        theActorInTheSpotlight().should(seeThat(ValidarEditarProducto.validarEditarProducto()));
    }
}
