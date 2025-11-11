package co.com.Automatizacion.userinterface.login.venta;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CrearVenta {

    public static final Target BTN_CREAR_VENTA = Target.the("Botón Crear venta")
            .located(By.cssSelector("img[src='https://cdn-icons-gif.flaticon.com/11186/11186846.gif']"));
}
