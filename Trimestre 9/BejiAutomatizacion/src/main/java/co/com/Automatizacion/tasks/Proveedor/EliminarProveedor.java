package co.com.Automatizacion.tasks.Proveedor;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.Alert;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static co.com.Automatizacion.userinterface.Proveedor.Proveedor.BTN_ELIMINAR_PROVEEDOR;

public class EliminarProveedor implements Task {

    private final String nit;

    public EliminarProveedor(String nit) {
        this.nit = nit;
    }

    public static EliminarProveedor conNit(String nit) {
        return Instrumented.instanceOf(EliminarProveedor.class).withProperties(nit);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(BTN_ELIMINAR_PROVEEDOR(nit))
        );

        Alert alert = BrowseTheWeb.as(actor).getDriver().switchTo().alert();
        alert.accept();
    }
}

