package co.com.Automatizacion.tasks.login;

import co.com.Automatizacion.userinterface.login.InicioPagina;
import co.com.Automatizacion.userinterface.login.Pagina;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class ClickEnVenta implements Task {

    public static ClickEnVenta ahora() {
        return Tasks.instrumented(ClickEnVenta.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(Pagina.BOTON_VENTA)
        );
    }
}
