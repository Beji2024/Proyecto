package co.com.Automatizacion.userinterface.Usuarios;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
@DefaultUrl(value= "http://localhost:4200/principal")
public class Login extends PageObject{

    public static Target INPUT_EMAIL = Target.the("Correo electronico")
            .located(By.id("email"));
    public static Target INPUT_PASSWORD = Target.the("Contraseña")
            .located(By.id("password"));
    public static Target BTN_INGRESAR = Target.the("Boton de ingreso")
            .located(By.id("ingresar"));
    public static Target ROL = Target.the("Rol de ingreso")
            .located(By.id("rol"));
}
