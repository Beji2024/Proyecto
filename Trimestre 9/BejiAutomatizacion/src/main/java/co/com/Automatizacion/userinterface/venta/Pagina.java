package co.com.Automatizacion.userinterface.venta;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Pagina {

    public static final Target BOTON_VENTA = Target.the("Botón Venta")
            .located(By.id("venta"));
}
