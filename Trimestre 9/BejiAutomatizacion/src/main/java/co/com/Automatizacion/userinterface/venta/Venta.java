package co.com.Automatizacion.userinterface.venta;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Venta {
    public static final Target BTN_REALIZAR_CAMBIO = Target.the("Botón para realizar un cambio o devolución")
            .located(By.xpath("//img[contains(@src,'6345534.png')]"));

    public static final Target BTN_CAMBIOS = Target.the("Botón para ingresar al módulo de Cambios")
            .located(By.xpath("//img[contains(@src,'12147202.gif')]"));

    public static final Target BTN_ICONO =
            Target.the("Botón del icono de cambios")
                    .located(By.xpath("//button[.//img[contains(@src,'5163824')]]"));

    public static final Target ESTADO_CAMBIO =
            Target.the("Estado del cambio")
                    .located(By.xpath("//tr[@class='text-center align-middle'][1]/td[last()]"));

    public static final Target IMAGEN_VENTA = Target.the("Imagen de venta")
            .located(By.xpath("/html/body/app-root/app-venta/div/div/div[3]/div/img"));

    public static final Target BTN_CREAR_VENTA = Target.the("Botón Crear venta")
            .located(By.cssSelector("img[src='https://cdn-icons-gif.flaticon.com/11186/11186846.gif']"));

    public static final Target SELECT_REFERENCIA = Target.the("selector referencia")
            .located(By.id("producto_id"));

    public static final Target SELECT_REFERENCIAA = Target.the("selector referencia")
            .located(By.id("REFERENCIA"));

    public static final Target BTN_GUARDAR = Target.the("Botón Guardar Cambios")
            .located(By.xpath("//button[contains(text(),'Guardar Cambios')]"));

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


    public static final Target CANTIDAD = Target.the("Cantidad de productos")
            .located(By.id("cantidad"));

    public static final Target SELECT_VENDEDOR = Target.the("Vendedor")
            .located(By.id("vendedor_id"));

    public static final Target BTN_REGISTRAR = Target.the("Botón Registrar Venta")
            .located(By.id("registrar"));

    public static Target INPUT_EMAIL = Target.the("Correo electronico")
            .located(By.id("email"));
    public static Target INPUT_PASSWORD = Target.the("Contraseña")
            .located(By.id("password"));
    public static Target BTN_INGRESAR = Target.the("Boton de ingreso")
            .located(By.id("ingresar"));

    public static final Target BOTON_VENTA = Target.the("Botón Venta")
            .located(By.id("venta"));

    public static final Target BTN_CONSULTAR_VENTA = Target.the("Botón Consultar Venta")
            .located(By.xpath("//img[contains(@src,'14255792.gif')]"));
    public static final Target CLIENTE_EN_TABLA(String nombre){
        return Target.the("el nombre es"+nombre)
            .located(By.xpath("//td[contains(text(),'"+nombre+"')]"));
    }
    public static final Target BTN_CAMBIA = Target.the("Botón cambio de la última fila")
            .located(By.cssSelector("table tbody tr:last-child button.btn.shadow"));
    public static final Target BTN_DEVOLUCION = Target.the("Botón devolucion de la última fila")
            .located(By.cssSelector("table tbody tr:last-child button.btn.ms-5"));


    public static final Target BTN_SIGUIENTE = Target.the("Botón Siguiente")
            .located(By.xpath("//button[contains(@class,'btn-outline-primary') and normalize-space()='Siguiente']"));

    public static final Target ESTADO_DEVOLUCION_TABLA = Target.the("Estado de la devolución en la última fila")
            .located(By.cssSelector("table tbody tr:last-child td:last-child"));

    public static final Target IMG_DEVOLUCION = Target.the("Último icono de devolución")
            .located(By.xpath("(//img[contains(@style,'cursor: pointer')])[last()]"));

    public static final Target SELECT_NUEVA_REFERENCIA = Target.the("Select Nueva Referencia")
            .located(By.xpath("//div[contains(@class,'form-group')]//label[normalize-space()='Nueva Referencia']/following::select[1]"));










}
