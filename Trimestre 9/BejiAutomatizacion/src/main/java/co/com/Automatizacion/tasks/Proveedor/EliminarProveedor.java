package co.com.Automatizacion.tasks.Proveedor;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static co.com.Automatizacion.userinterface.Proveedor.Proveedor.BTN_ELIMINAR_PROVEEDOR;

public class EliminarProveedor implements Task {

    private final String nit;

    public EliminarProveedor(String nit) {
        this.nit = nit;
    }

    public static EliminarProveedor conNIT(String nit) {
        return Instrumented.instanceOf(EliminarProveedor.class).withProperties(nit);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);

        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//tr[td[text()='" + nit + "']]")
        ));

        WebElementFacade btnEliminar = BrowseTheWeb.as(actor)
                .findBy("//tr[td[text()='" + nit + "']]//button[contains(@class,'btn-danger')]");

        btnEliminar.waitUntilEnabled();
        btnEliminar.click();

        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert1 = driver.switchTo().alert();
            alert1.accept();
        } catch (Exception e) {
            System.out.println("No se encontró el primer alert: " + e.getMessage());
        }
    }

}


