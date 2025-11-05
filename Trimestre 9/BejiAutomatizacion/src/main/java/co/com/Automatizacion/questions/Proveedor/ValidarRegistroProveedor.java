package co.com.Automatizacion.questions.Proveedor;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ValidarRegistroProveedor implements Question<Boolean> {

    private final String nombreProveedor;

    public ValidarRegistroProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public static ValidarRegistroProveedor conNombre(String nombreProveedor) {
        return new ValidarRegistroProveedor(nombreProveedor);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table.table")));

            String nombreProveedorMinusculas = nombreProveedor.toLowerCase().trim();

            String xpath = "//table//tbody//tr[td[1][contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"
                    + nombreProveedorMinusculas + "')]]";

            WebElement filaProveedor = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

            return filaProveedor.isDisplayed();

        } catch (TimeoutException e) {
            System.out.println("No se encontró el proveedor '" + nombreProveedor + "' en la tabla.");
            return false;
        }
    }
}