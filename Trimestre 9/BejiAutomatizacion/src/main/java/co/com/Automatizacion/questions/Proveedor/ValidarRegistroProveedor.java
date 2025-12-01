package co.com.Automatizacion.questions.Proveedor;

import co.com.Automatizacion.interactions.ScrollBottom;
import co.com.Automatizacion.userinterface.Proveedor.Proveedor;
import co.com.Automatizacion.utils.hooks.Usuarios.RegistroVariable;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class ValidarRegistroProveedor implements Question<Boolean> {

    private static final Logger logger = LoggerFactory.getLogger(ValidarRegistroProveedor.class);

    public static ValidarRegistroProveedor esCorrecto() {
        return new ValidarRegistroProveedor();
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        String nit = actor.recall(RegistroVariable.PROVEEDOR_NIT.name());
        if (nit == null) {
            logger.error("No se encontró el NIT del proveedor en memoria.");
            return false;
        }

        logger.info("Buscando NIT '{}' en la tabla de proveedores...", nit);

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 40);

        int pagina = 1;

        while (true) {
            logger.info("Revisando página {}", pagina);

            // Obtener NITs de la página actual
            List<WebElementFacade> listaNitsFacade = Proveedor.COLUMNA_NIT.resolveAllFor(actor);
            wait.until(ExpectedConditions.visibilityOfAllElements(
                    listaNitsFacade.stream().map(WebElementFacade::getWrappedElement).collect(Collectors.toList())
            ));

            // Revisar si existe el NIT
            for (WebElementFacade celda : listaNitsFacade) {
                String nitEnTabla = celda.getText().trim();
                logger.info("NIT encontrado en tabla: {}", nitEnTabla);

                if (nitEnTabla.equals(nit.trim())) {
                    logger.info("✔ NIT '{}' encontrado en página {}", nit, pagina);
                    return true;
                }
            }

            // Obtener el botón Siguiente de nuevo
            List<WebElementFacade> btnSiguiente = Proveedor.BTN_SIGUIENTE.resolveAllFor(actor);

            if (btnSiguiente.isEmpty() || !btnSiguiente.get(0).isVisible()) {
                logger.warn("No hay más páginas disponibles. NIT '{}' NO encontrado.", nit);
                break;
            }

            WebElementFacade siguiente = btnSiguiente.get(0);

            logger.info("Esperando que el botón 'Siguiente' esté listo...");
            wait.until(ExpectedConditions.elementToBeClickable(siguiente));

            actor.attemptsTo(ScrollBottom.completo());

            // Guardar referencia a los NITs actuales para esperar que se vuelvan stale
            List<WebElement> nitsActuales = listaNitsFacade.stream()
                    .map(WebElementFacade::getWrappedElement)
                            .collect(Collectors.toList());

            logger.info("Clic en botón 'Siguiente'...");
            siguiente.click();

            // Esperar que la tabla antigua desaparezca
            wait.until(ExpectedConditions.stalenessOf(nitsActuales.get(0)));

            pagina++;
        }

        return false;
    }
}
