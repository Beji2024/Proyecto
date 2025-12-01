package co.com.Automatizacion.questions.Proveedor;

import co.com.Automatizacion.interactions.ScrollBottom;
import co.com.Automatizacion.userinterface.Proveedor.EditarProveedor;
import co.com.Automatizacion.utils.hooks.Usuarios.RegistroVariable;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ValidarEdicionProveedor implements Question<Boolean> {

    private static final Logger logger = LoggerFactory.getLogger(ValidarEdicionProveedor.class);

    public static ValidarEdicionProveedor validarEdicionProveedor() {
        return new ValidarEdicionProveedor();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            String emailActualizado = actor.recall(RegistroVariable.proveedor.toString());

            if (emailActualizado == null) {
                logger.error("No se encontró el email actualizado del proveedor en memoria");
                return false;
            }

            logger.info("Buscando proveedor con email '{}'", emailActualizado);

            boolean encontrado = false;
            int pagina = 1;

            while (true) {
                logger.info("Verificando página {}...", pagina);

                List<WebElementFacade> correos = EditarProveedor.COL_EMAIL_TABLA.resolveAllFor(actor);
                for (WebElementFacade celda : correos) {
                    String texto = celda.getText().trim();
                    if (texto.equalsIgnoreCase(emailActualizado)) {
                        encontrado = true;
                        break;
                    }
                }

                if (encontrado) break;
                List<WebElementFacade> siguiente = EditarProveedor.BTN_SIGUIENTE.resolveAllFor(actor);
                if (siguiente.isEmpty() || !siguiente.get(0).isVisible()) {
                    logger.warn("Fin de tabla: no hay más páginas para buscar");
                    break;
                }

                WebDriver driver = BrowseTheWeb.as(actor).getDriver();
                WebDriverWait wait = new WebDriverWait(driver, 20); // espera hasta 20 seg
                wait.until(ExpectedConditions.elementToBeClickable(siguiente.get(0)));

                actor.attemptsTo(ScrollBottom.completo());
                actor.attemptsTo(JavaScriptClick.on(EditarProveedor.BTN_SIGUIENTE));

                pagina++;
            }

            return encontrado;

        } catch (Exception e) {
            logger.error("Error durante la validación: " + e.getMessage(), e);
            return false;
        }
    }
}
