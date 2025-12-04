package co.com.Automatizacion.tasks.Proveedor;

import co.com.Automatizacion.interactions.AceptarAlerta;
import co.com.Automatizacion.models.Proveedor.DatosProveedor;
import co.com.Automatizacion.utils.hooks.Usuarios.RegistroVariable;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static co.com.Automatizacion.userinterface.Proveedor.EditarProveedor.*;

public class EditarProveedor implements Task {

    private final DatosProveedor datos;
    private final Random random = new Random();
    private final int numero = random.nextInt(1000);

    public EditarProveedor(List<DatosProveedor> datos) {
        this.datos = datos.get(0);
    }

    public static EditarProveedor conDatos(List<DatosProveedor> datos) {
        return Instrumented.instanceOf(EditarProveedor.class).withProperties(datos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        List<WebElementFacade> todosLosBotones = new ArrayList<>();
        boolean haySiguiente = true;

        while (haySiguiente) {
            List<WebElementFacade> botonesPagina = BrowseTheWeb.as(actor)
                    .findAll("//button[contains(.,'Editar')]");
            todosLosBotones.addAll(botonesPagina);

            List<WebElementFacade> btnSiguiente = BTN_SIGUIENTE.resolveAllFor(actor);
            if (btnSiguiente.isEmpty() || !btnSiguiente.get(0).isVisible()) {
                haySiguiente = false;
            } else {
                WebElementFacade siguiente = btnSiguiente.get(0);
                try {
                    new WebDriverWait(driver, 4)
                            .until(ExpectedConditions.elementToBeClickable(siguiente));
                    siguiente.click();
                    Thread.sleep(200);
                } catch (Exception e) {
                    haySiguiente = false;
                }
            }
        }

        int index = random.nextInt(todosLosBotones.size());
        WebElementFacade editarSeleccionado = todosLosBotones.get(index);
        editarSeleccionado.click();

        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.visibilityOf(EDT_CELULAR.resolveFor(actor)));

        String emailBase = datos.getEmail();
        String[] partes = emailBase.split("@");
        String emailRandom = partes[0] + numero + "@" + partes[1];

        actor.attemptsTo(
                Clear.field(EDT_CELULAR),
                Enter.theValue(datos.getCelular()).into(EDT_CELULAR),

                Clear.field(EDT_EMAIL),
                Enter.theValue(emailRandom).into(EDT_EMAIL),

                Clear.field(EDT_DIRECCION),
                Enter.theValue(datos.getDireccion() + numero).into(EDT_DIRECCION),

                Click.on(BTN_ACTUALIZAR)
        );

        actor.attemptsTo(AceptarAlerta.ahora());
        try {
            WebDriverWait waitAlerta = new WebDriverWait(driver, 4);
            waitAlerta.until(ExpectedConditions.alertIsPresent());
            actor.attemptsTo(AceptarAlerta.ahora());
        } catch (Exception e) {
            System.out.println("No apareció el segundo alert dentro del tiempo esperado");
        }
        actor.remember(RegistroVariable.proveedor.toString(), emailRandom);
    }
}
