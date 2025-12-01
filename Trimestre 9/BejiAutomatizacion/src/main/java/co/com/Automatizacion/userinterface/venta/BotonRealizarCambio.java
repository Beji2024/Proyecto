package co.com.Automatizacion.userinterface.venta;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BotonRealizarCambio {

    public static final Target BTN_REALIZAR_CAMBIO = Target.the("Botón para realizar un cambio o devolución")
            .located(By.xpath("//img[contains(@src,'6345534.png')]"));

}
