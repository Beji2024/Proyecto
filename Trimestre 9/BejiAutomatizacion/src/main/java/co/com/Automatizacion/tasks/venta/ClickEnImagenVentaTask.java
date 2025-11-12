package co.com.Automatizacion.tasks.venta;

import co.com.Automatizacion.userinterface.venta.ClickEnImagenVenta;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class ClickEnImagenVentaTask implements Task {

    @Override
    @Step("{0} hace click en la imagen de venta")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ClickEnImagenVenta.IMAGEN_VENTA)
        );
    }

    public static ClickEnImagenVentaTask ahora() {
        return Tasks.instrumented(ClickEnImagenVentaTask.class);
    }
}
