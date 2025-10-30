package co.com.Automatizacion.questions.registrarUsuario;

import co.com.Automatizacion.utils.hooks.registrarUsuario.VaribaleRegistro;
import net.serenitybdd.screenplay.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.questions.Text;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import java.util.List;
import static co.com.Automatizacion.userinterface.registrarUsuario.RegistrarUsuario.COLUMNA_DOCUMENTO;

public class ValidacionRegistro  implements Question<Boolean>{

    private static final Logger logger = LoggerFactory.getLogger(ValidacionRegistro.class);
    public static ValidacionRegistro validacionRegistro(){return new ValidacionRegistro();}

    @Override
    public Boolean answeredBy(Actor actor){
        try{
            String documento = theActorInTheSpotlight().recall(VaribaleRegistro.registro.toString());
            logger.info("Validando que el usuario este en los registros");
            List<String> documentos = Text.of(COLUMNA_DOCUMENTO).viewedBy(actor).asList();

            for (String documen: documentos){
                if(documen.equalsIgnoreCase(documento)){
                    logger.info("Documento encontrado en los registros");
                    return true;
                }
            }

            logger.warn("El documento no fue encontrado en los registros");
            return false;
        }catch(Exception e){
            logger.error("Hubo un error al realizar el registro del usuario"+ e.getMessage());
            return false;
        }
    }
}
