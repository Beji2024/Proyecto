package co.com.Automatizacion.userinterface.venta;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Cambios {

    public static final Target BTN_CAMBIOS = Target.the("Botón para ingresar al módulo de Cambios")
            .located(By.xpath("//img[contains(@src,'12147202.gif')]"));

}
