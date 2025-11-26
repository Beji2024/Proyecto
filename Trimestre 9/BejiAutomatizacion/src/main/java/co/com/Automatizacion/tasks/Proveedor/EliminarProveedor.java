package co.com.Automatizacion.tasks.Proveedor;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static net.serenitybdd.screenplay.actions.Click.on;
import static co.com.Automatizacion.userinterface.Proveedor.Proveedor.BTN_SIGUIENTE;

public class EliminarProveedor implements Task {

    private final Random random = new Random();

    public static EliminarProveedor deTodasLasPaginas() {
        return Instrumented.instanceOf(EliminarProveedor.class).withProperties();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        List<WebElementFacade> todosLosProveedores = new ArrayList<>();
        boolean haySiguiente = true;

        // Recorrer todas las páginas
        while (haySiguiente) {
            List<WebElementFacade> proveedoresPagina = BrowseTheWeb.as(actor)
                    .findAll("//tr/td[1]"); // Suponiendo que NIT está en la primera columna
            todosLosProveedores.addAll(proveedoresPagina);

            List<WebElementFacade> btnSiguiente = BTN_SIGUIENTE.resolveAllFor(actor);
            if (btnSiguiente.isEmpty() || !btnSiguiente.get(0).isVisible()) {
                haySiguiente = false;
            } else {
                try {
                    wait.until(ExpectedConditions.elementToBeClickable(btnSiguiente.get(0)));
                    btnSiguiente.get(0).click();
                    Thread.sleep(1200); // esperar que cargue la página
                } catch (Exception e) {
                    haySiguiente = false;
                }
            }
        }

        if (todosLosProveedores.isEmpty()) {
            throw new RuntimeException("No hay proveedores disponibles para eliminar.");
        }

        // Elegir un proveedor aleatorio
        int index = random.nextInt(todosLosProveedores.size());
        String nitElegido = todosLosProveedores.get(index).getText();

        // Hacer clic en el botón eliminar del proveedor seleccionado
        WebElementFacade btnEliminar = BrowseTheWeb.as(actor)
                .findBy("//td[text()='" + nitElegido + "']/following-sibling::td//button[contains(@class,'btn-danger')]");

        wait.until(ExpectedConditions.elementToBeClickable(btnEliminar));
        btnEliminar.click();

        // Aceptar alert
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert1 = driver.switchTo().alert();
            alert1.accept();
        } catch (Exception e) {
            System.out.println("No apareció la alerta: " + e.getMessage());
        }

        // Guardar el NIT eliminado para validación
        actor.remember("NIT_ELIMINADO", nitElegido);
    }
}
