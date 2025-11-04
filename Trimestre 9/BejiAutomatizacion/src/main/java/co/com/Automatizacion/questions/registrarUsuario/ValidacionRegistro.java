package co.com.Automatizacion.questions.registrarUsuario;

import co.com.Automatizacion.userinterface.registrarUsuario.RegistrarUsuario;
import co.com.Automatizacion.utils.hooks.registrarUsuario.VaribaleRegistro;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.Text;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class ValidacionRegistro implements Question<Boolean> {

    private static final Logger logger = LoggerFactory.getLogger(ValidacionRegistro.class);

    public static ValidacionRegistro validacionRegistro() {
        return new ValidacionRegistro();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            //Recuperar el número de documento almacenado en la Task
            String documento = Serenity.sessionVariableCalled(VaribaleRegistro.registro.toString());
            if (documento == null) {
                documento = actor.recall(VaribaleRegistro.registro.toString());
            }

            if (documento == null) {
                logger.error("No se encontró el número de documento en memoria para validar.");
                return false;
            }

            logger.info("Validando si el documento '{}' está en los registros...", documento);

            WebDriver driver = BrowseTheWeb.as(actor).getDriver();
            JavascriptExecutor js = (JavascriptExecutor) driver;

            boolean encontrado = false;
            int pagina = 1;

            //Recorre todas las páginas hasta encontrar el documento o no queden más
            while (true) {
                logger.info("Verificando página {}...", pagina);

                //Buscar todas las celdas donde aparece el documento
                List<WebElementFacade> documentos = RegistrarUsuario.COLUMNA_DOCUMENTO.resolveAllFor(actor);

                for (WebElementFacade celda : documentos) {
                    String textoCelda = celda.getText().trim();
                    logger.info("   → Documento en tabla: '{}'", textoCelda);

                    if (textoCelda.contains(documento.trim())) {
                        logger.info("Documento '{}' encontrado en la página {}", documento, pagina);
                        encontrado = true;
                        break;
                    }
                }

                if (encontrado) break;

                //Buscar botón “Siguiente”
                List<WebElementFacade> botonesSiguiente = RegistrarUsuario.BTN_SIGUIENTE.resolveAllFor(actor);

                if (botonesSiguiente.isEmpty() || !botonesSiguiente.get(0).isVisible()) {
                    logger.warn("No hay más páginas para recorrer o el botón 'Siguiente' no está visible.");
                    break;
                }

                //Hacer scroll hasta el final antes de hacer clic
                js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                Thread.sleep(1000);

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