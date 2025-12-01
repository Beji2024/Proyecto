package co.com.Automatizacion.userinterface.venta;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BotonDevoluciones {
    public static final Target BTN_DEVOLUCIONES = Target.the("Botón Devoluciones")
            .located(By.xpath("//button[img[contains(@src,'5163824')]]"));

}
