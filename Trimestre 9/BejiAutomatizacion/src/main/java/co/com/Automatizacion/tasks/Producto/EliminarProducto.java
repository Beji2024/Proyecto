package co.com.Automatizacion.tasks.Producto;

import co.com.Automatizacion.interactions.Esperar;
import co.com.Automatizacion.userinterface.Productos.Producto;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebElement;
import java.util.List;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EliminarProducto implements Task {

    public static String nombreProductoEliminado;

    public static EliminarProducto delListado() {
        return instrumented(EliminarProducto.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        List<WebElementFacade> filas = Producto.FILAS_TABLA.resolveAllFor(actor);
        WebElementFacade ultimaFila = filas.get(filas.size() - 1);
        WebElement nombreCelda = ultimaFila.findElement(Producto.NOMBRE_PRODUCTO_EN_FILA);
        nombreProductoEliminado = nombreCelda.getText().trim();

        actor.attemptsTo(
                WaitUntil.the(Producto.BTN_ELIMINAR_ULTIMO, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(Producto.BTN_ELIMINAR_ULTIMO),
                WaitUntil.the(Producto.BTN_ELIMINARCONFIRMACION, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(Producto.BTN_ELIMINARCONFIRMACION),
                Esperar.segundos(3)
        );

    }
}
