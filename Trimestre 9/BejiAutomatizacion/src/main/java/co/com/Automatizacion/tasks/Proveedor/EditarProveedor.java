package co.com.Automatizacion.tasks.Proveedor;

import co.com.Automatizacion.models.Proveedor.DatosProveedor;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static co.com.Automatizacion.userinterface.Proveedor.Proveedor.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EditarProveedor implements Task {

    private final String nit;
    private final List<DatosProveedor> datos;

    public EditarProveedor(String nit, List<DatosProveedor> datos) {
        this.nit = nit;
        this.datos = datos;
    }

    public static EditarProveedor conDatos(String nit, List<DatosProveedor> datos) {
        return Instrumented.instanceOf(EditarProveedor.class).withProperties(nit, datos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        DatosProveedor proveedor = datos.get(0);
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);

        actor.attemptsTo(
                WaitUntil.the(BTN_EDITAR_PROVEEDOR.of(nit), isVisible()).forNoMoreThan(10).seconds(),
                Click.on(BTN_EDITAR_PROVEEDOR.of(nit))
        );

        actor.attemptsTo(
                Clear.field(EDT_CELULAR),
                Enter.theValue(proveedor.getCelular()).into(EDT_CELULAR),

                Clear.field(EDT_EMAIL),
                Enter.theValue(proveedor.getEmail()).into(EDT_EMAIL),

                Clear.field(EDT_DIRECCION),
                Enter.theValue(proveedor.getDireccion()).into(EDT_DIRECCION),

                Click.on(BTN_ACTUALIZAR)
        );

        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert1 = driver.switchTo().alert();
            alert1.accept();

            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert2 = driver.switchTo().alert();
            System.out.println("Mensaje del sistema: " + alert2.getText());
            alert2.accept();

        } catch (Exception e) {
            System.out.println("No se encontraron todos los alerts: " + e.getMessage());
        }
    }
}
