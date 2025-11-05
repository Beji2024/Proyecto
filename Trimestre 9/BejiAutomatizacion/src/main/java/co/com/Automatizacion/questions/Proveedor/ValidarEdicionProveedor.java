package co.com.Automatizacion.questions.Proveedor;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ValidarEdicionProveedor implements Question<Boolean> {

    private static final String MENSAJE_ESPERADO = "actualizado";

    public static ValidarEdicionProveedor correctamente() {
        return new ValidarEdicionProveedor();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert1 = driver.switchTo().alert();
            alert1.accept();

            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert2 = driver.switchTo().alert();
            String mensaje = alert2.getText().toLowerCase();
            alert2.accept();

            return mensaje.contains(MENSAJE_ESPERADO);
        } catch (Exception e) {
            System.out.println("No se encontró alguno de los alerts: " + e.getMessage());
            return false;
        }
    }
}

