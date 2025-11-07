package co.com.Automatizacion.questions;

import co.com.Automatizacion.interactions.ScrollBottom;
import co.com.Automatizacion.userinterface.EditarUsuario;
import co.com.Automatizacion.utils.hooks.RegistroVariable;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Question;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import net.serenitybdd.screenplay.Actor;

import java.util.List;

public class ValidacionEditar implements Question<Boolean> {

    private static final Logger logger = LoggerFactory.getLogger(ValidacionEditar.class);
    public static ValidacionEditar validacionEditar() {return new ValidacionEditar();}

    @Override
    public Boolean answeredBy(Actor actor){
        try {
            String apellido = actor.recall(RegistroVariable.usuario.toString());

            if (apellido == null) {
                logger.error("No se encontro el apellido de en memoria para validar");
                return false;
            }
            logger.info("Validando si el apellido '{}' esta en los registros...", apellido);

            boolean encontrado = false;
            int pagina = 1;

            while (true) {
                logger.info("Verificando página {}...", pagina);
                List<WebElementFacade> apellidos = EditarUsuario.COLUMNA_APELLIDO.resolveAllFor(actor);
                for (WebElementFacade celda : apellidos) {
                    String textoCelda = celda.getText().trim();
                    logger.info("Apellido en la tabla '{}'", textoCelda);
                    if (textoCelda.contains(apellido.trim())) {
                        logger.info("Apellido '{}' encontrado en la pagina '{}'", apellido, pagina);
                        encontrado = true;
                        break;
                    }
                }
                if (encontrado) break;
                List<WebElementFacade> siguiente = EditarUsuario.BTN_SIGUIENTE.resolveAllFor(actor);

                if (siguiente.isEmpty() || !siguiente.get(0).isVisible()) {
                    logger.warn("No hay mas paginas para recorrer o el boton 'siguiente' no esta visible");
                    break;
                }
                    actor.attemptsTo(ScrollBottom.completo());

                    logger.info("Pasando a la siguiente página...");
                    siguiente.get(0).click();
                    Thread.sleep(2000);
                    pagina++;
                }
                if (!encontrado) {
                    logger.warn("El apellido '{}' no fue encontrado en ninguna pagina.", apellido);
                }

                return encontrado;

            }catch(Exception e){
                logger.error("Error durante la validacion de la edicion: " + e.getMessage(), e);
                return false;
        }
    }
}
