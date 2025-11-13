package co.com.Automatizacion.userinterface.login.venta;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

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
