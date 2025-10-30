package co.com.Automatizacion.interactions.registrarUsuario;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;

public class AceptarAlerta implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = ThucydidesWebDriverSupport.getDriver();

        try {
            // Esperar un momento para que aparezca la alerta
            Thread.sleep(1000);

            Alert alert = driver.switchTo().alert();
            System.out.println("Texto de la alerta: " + alert.getText());
            alert.accept(); // Clic en "Aceptar"

        } catch (Exception e) {
            System.out.println("No se encontró ninguna alerta: " + e.getMessage());
        }
    }

    public static AceptarAlerta ahora() {
        return Tasks.instrumented(AceptarAlerta.class);
    }
}
