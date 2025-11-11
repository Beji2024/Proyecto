package co.com.Automatizacion.tasks.login.venta;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class VolverAtras implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {


        BrowseTheWeb.as(actor).getDriver().navigate().back();
    }

    public static VolverAtras ahora() {
        return Tasks.instrumented(VolverAtras.class);
    }
}
