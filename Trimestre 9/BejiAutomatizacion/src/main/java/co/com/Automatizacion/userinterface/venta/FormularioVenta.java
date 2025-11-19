package co.com.Automatizacion.userinterface.venta;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FormularioVenta {

    public static final Target NOMBRE_CLIENTE = Target.the("Nombre del cliente")
            .located(By.id("nombre_cli"));

    public static final Target DIRECCION_CLIENTE = Target.the("Dirección del cliente")
            .located(By.id("direccion_cli"));

    public static final Target CORREO_CLIENTE = Target.the("Correo del cliente")
            .located(By.id("correo_cli"));

    public static final Target TELEFONO_CLIENTE = Target.the("Número de teléfono")
            .located(By.id("num_tel_cli"));

    public static final Target DOCUMENTO_CLIENTE = Target.the("Número de documento")
            .located(By.id("num_doc_cli"));

    public static final Target SELECT_REFERENCIA = Target.the("Referencia del producto")
            .located(By.id("producto_id"));

    public static final Target CANTIDAD = Target.the("Cantidad de productos")
            .located(By.id("cantidad"));

    public static final Target SELECT_VENDEDOR = Target.the("Vendedor")
            .located(By.id("vendedor_id"));

    public static final Target BTN_REGISTRAR = Target.the("Botón Registrar Venta")
            .located(By.xpath("/html/body/app-root/app-crear-venta/div/form/div[9]/button"));
}
