package co.com.Automatizacion.stepsdefinitions.Productos;

<<<<<<< HEAD
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;

public class EliminarProductosStepDefinition {
    @Cuando("^acceda al módulo de gestión de productos$")
    public void accedaAlMóduloDeGestiónDeProductos() {

    }

    @Cuando("^visualice la tabla con la lista de productos registrados$")
    public void visualiceLaTablaConLaListaDeProductosRegistrados() {

    }

    @Cuando("^en la lista identifique el producto que desea eliminar$")
    public void enLaListaIdentifiqueElProductoQueDeseaEliminar() {

    }

    @Cuando("^dé clic en la opción \"([^\"]*)\" correspondiente a ese producto$")
    public void déClicEnLaOpciónCorrespondienteAEseProducto(String arg1) {

    }

    @Cuando("^confirme la acción de eliminación$")
    public void confirmeLaAcciónDeEliminación() {

    }

    @Entonces("^se debe verificar que el producto eliminado ya no aparezca en la tabla de productos registrados$")
    public void seDebeVerificarQueElProductoEliminadoYaNoAparezcaEnLaTablaDeProductosRegistrados() {

    }
}
=======
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

>>>>>>> 18e8930b7b9e2bfa3724a8a7e49dfff8973d0548
