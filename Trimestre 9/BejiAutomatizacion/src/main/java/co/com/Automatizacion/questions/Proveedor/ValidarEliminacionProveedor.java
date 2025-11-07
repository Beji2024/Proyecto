package co.com.Automatizacion.questions.Proveedor;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ValidarEliminacionProveedor implements Question<Boolean> {

    private final String nit;

    public ValidarEliminacionProveedor(String nit) {
        this.nit = nit;
    }

    public static ValidarEliminacionProveedor noExiste(String nit) {
        return new ValidarEliminacionProveedor(nit);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        By selector = By.xpath("//td[contains(normalize-space(.),'" + nit + "')]");
        WebDriverWait wait = new WebDriverWait(driver, 30);

        try {
            boolean desaparecio = wait.until(
                    ExpectedConditions.invisibilityOfElementLocated(selector)
            );
            return desaparecio;
        } catch (Exception e) {
            List<WebElementFacade> elementos = BrowseTheWeb.as(actor).findAll(selector);
            return elementos.isEmpty();
        }
    }
}
