package co.com.Automatizacion.userinterface.venta;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ClickEnImagenVenta {

    public static final Target IMAGEN_VENTA = Target.the("Imagen de venta")
            .located(By.xpath("/html/body/app-root/app-venta/div/div/div[3]/div/img"));
}
