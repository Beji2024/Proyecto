package co.com.Automatizacion.tasks.Proveedor;

import co.com.Automatizacion.models.Proveedor.DatosProveedor;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.screenplay.Task;
import java.util.List;

import static co.com.Automatizacion.userinterface.Proveedor.Proveedor.*;

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
        WebDriverWait wait = new WebDriverWait(driver, 10);

        actor.attemptsTo(
                Click.on(BTN_EDITAR_PROVEEDOR(nit)),

                Click.on(TXT_NOMBRE),
                Enter.theValue(proveedor.getNombre()).into(TXT_NOMBRE),

                Click.on(TXT_NIT),
                Enter.theValue(proveedor.getNit()).into(TXT_NIT),

                Click.on(TXT_CELULAR),
                Enter.theValue(proveedor.getCelular()).into(TXT_CELULAR),

                Click.on(TXT_EMAIL),
                Enter.theValue(proveedor.getEmail()).into(TXT_EMAIL),

                Click.on(TXT_DIRECCION),
                Enter.theValue(proveedor.getDireccion()).into(TXT_DIRECCION),

                Click.on(BTN_REGISTRAR) // Asumiendo que es el mismo botón que guarda cambios
        );

        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert1 = driver.switchTo().alert();
            alert1.accept();
        } catch (Exception e) {
            System.out.println("⚠️ No se encontró el primer alert: " + e.getMessage());
        }

        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert2 = driver.switchTo().alert();
            alert2.accept();
        } catch (Exception e) {
            System.out.println("⚠️ No se encontró el segundo alert: " + e.getMessage());
        }
    }
}

