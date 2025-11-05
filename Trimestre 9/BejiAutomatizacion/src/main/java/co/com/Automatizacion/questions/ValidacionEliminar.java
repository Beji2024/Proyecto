package co.com.Automatizacion.questions;

import co.com.Automatizacion.userinterface.EliminarUsuario;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.serenitybdd.screenplay.Actor;
import co.com.Automatizacion.utils.hooks.RegistroVariable;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.List;

public class ValidacionEliminar implements Question<Boolean> {

    private static final Logger logger = LoggerFactory.getLogger(ValidacionEliminar.class);

    public static ValidacionEliminar validacionEliminar() {
        return new ValidacionEliminar();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            String documento = Serenity.sessionVariableCalled(RegistroVariable.usuario.toString());
            if (documento == null) {
                documento = actor.recall(RegistroVariable.usuario.toString());
            }
            if (documento == null) {
                logger.error("No se encontró el número de documento para validar");
                return false; // Si no hay documento, no puede validarse
            }

            logger.info("Validando que el documento '{}' ya no esté en los registros...", documento);

            WebDriver driver = BrowseTheWeb.as(actor).getDriver();
            boolean encontrado = false;

            // Solo revisar la página actual
            List<WebElementFacade> documentos = EliminarUsuario.COLUMNA_DOCUMENTO.resolveAllFor(actor);

            for (WebElementFacade celda : documentos) {
                String textoCelda = celda.getText().trim();
                logger.info("Documento en tabla: '{}'", textoCelda);

                if (textoCelda.equalsIgnoreCase(documento.trim())) {
                    logger.warn("Documento '{}' todavía encontrado en la página actual", documento);
                    encontrado = true;
                    break;
                }
            }

            boolean eliminado = !encontrado;

            if (eliminado) {
                logger.info("El documento '{}' fue eliminado correctamente", documento);
            } else {
                logger.error("El documento '{}' todavía existe en la tabla", documento);
            }

            return eliminado;

        } catch (Exception e) {
            logger.error("Error durante la validación de eliminación: " + e.getMessage(), e);
            return false;
        }
    }
}
