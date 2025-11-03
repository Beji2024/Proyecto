package co.com.Automatizacion.questions.login;

import net.serenitybdd.screenplay.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.questions.Text;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import java.util.List;
import static co.com.Automatizacion.userinterface.login.Login.ROL;
public class ValidacionLogin implements Question<Boolean> {

    private static final Logger logger = LoggerFactory.getLogger(ValidacionLogin.class);
    public static ValidacionLogin validacionLogin(){return new ValidacionLogin();}

    @Override
    public Boolean answeredBy(Actor actor){
        try{
            String rol = "administrador";
            logger.info("Validando que el logueo sea correcto");
            String validar = Text.of(ROL).viewedBy(actor).asString();

            if (rol.equalsIgnoreCase(validar)){
                logger.info("El usuario se logueo correctamente");
                return true;
            }
            logger.warn("El logueo no se realizo");
            return  false;
        }catch(Exception e){
            logger.error("Datos incorrectos para realizar el login"+ e.getMessage());
            return false;
        }
    }
}
