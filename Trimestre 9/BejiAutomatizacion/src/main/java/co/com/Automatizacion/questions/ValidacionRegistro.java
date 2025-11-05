package co.com.Automatizacion.questions;

import co.com.Automatizacion.userinterface.RegistrarUsuario;
import co.com.Automatizacion.utils.hooks.RegistroVariable;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import co.com.Automatizacion.interactions.ScrollBottom;

public class ValidacionRegistro implements Question<Boolean> {

    private static final Logger logger = LoggerFactory.getLogger(ValidacionRegistro.class);

    public static ValidacionRegistro validacionRegistro() {
        return new ValidacionRegistro();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            // Recuperar el número de documento almacenado
            String documento = Serenity.sessionVariableCalled(RegistroVariable.usuario.toString());
            if (documento == null) {
                documento = actor.recall(RegistroVariable.usuario.toString());
            }

            if (documento == null) {
                logger.error("No se encontró el número de documento en memoria para validar.");
                return false;
            }

            logger.info("Validando si el documento '{}' está en los registros...", documento);

            WebDriver driver = BrowseTheWeb.as(actor).getDriver();
            boolean encontrado = false;
            int pagina = 1;

            // Recorre todas las páginas hasta encontrar el documento o no queden más
            while (true) {
                logger.info("Verificando página {}...", pagina);

                List<WebElementFacade> documentos = RegistrarUsuario.COLUMNA_DOCUMENTO.resolveAllFor(actor);

                for (WebElementFacade celda : documentos) {
                    String textoCelda = celda.getText().trim();
                    logger.info("Documento en tabla: '{}'", textoCelda);

                    if (textoCelda.contains(documento.trim())) {
                        logger.info("Documento '{}' encontrado en la página {}", documento, pagina);
                        encontrado = true;
                        break;
                    }
                }

                if (encontrado) break;

                // Buscar botón “Siguiente”
                List<WebElementFacade> botonesSiguiente = RegistrarUsuario.BTN_SIGUIENTE.resolveAllFor(actor);

                if (botonesSiguiente.isEmpty() || !botonesSiguiente.get(0).isVisible()) {
                    logger.warn("No hay más páginas para recorrer o el botón 'Siguiente' no está visible.");
                    break;
                }

                actor.attemptsTo(ScrollBottom.completo());

                logger.info("Pasando a la siguiente página...");
                botonesSiguiente.get(0).click();
                Thread.sleep(2000); // Espera para cargar la nueva página

                pagina++;
            }

            if (!encontrado) {
                logger.warn("El documento '{}' no fue encontrado en ninguna página.", documento);
            }

            return encontrado;

        } catch (Exception e) {
            logger.error("Error durante la validación del registro: " + e.getMessage(), e);
            return false;
        }
    }
}