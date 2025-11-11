package co.com.Automatizacion.tasks.Producto;

import co.com.Automatizacion.userinterface.Productos.Producto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EliminarProducto implements Task {

    public static EliminarProducto delListado() {
        return instrumented(EliminarProducto.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(Producto.BTN_PRODUCTO),
                Click.on(Producto.BTN_MASOPCIONES),
                Click.on(Producto.BTN_GESTIONARPRODUCTOS),
                Click.on(Producto.BTN_ELIMINAR),
                Click.on(Producto.BTN_ELIMINARCONFIRMACION)
        );
    }
}
