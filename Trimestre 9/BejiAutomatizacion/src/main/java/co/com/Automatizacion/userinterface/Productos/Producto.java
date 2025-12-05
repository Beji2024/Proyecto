package co.com.Automatizacion.userinterface.Productos;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Producto extends PageObject {
    public static Target BTN_PRODUCTO =Target.the("Modulo Productos")
            .located(By.id("Producto"));

    public static Target BTN_MASOPCIONES =Target.the("mas opciones")
            .located(By.id("masOpciones"));

    public static Target BTN_GESTIONARPRODUCTOS =Target.the("Modulo Gestionar Productos")
            .located(By.id("gestionarProductos"));
    public static Target BTN_NUEVOPRODUCTO =Target.the("Registrar nuevo producto")
            .located(By.id("nuevoProducto"));

    public static Target BTN_ELIMINAR =Target.the("Boton Eliminar")
            .located(By.id("eliminar"));
    public static Target BTN_ELIMINARCONFIRMACION =Target.the("Comfirmar eliminacion de producto")
            .located(By.id("confirmar"));

    public static Target BTN_EDITAR =Target.the("Boton Editar")
            .located(By.id("editar"));

    public static final Target CAMPO_NOMBRE = Target.the("Campo nombre del producto")
            .located(By.id("nombre"));
    public static final Target CAMPO_CATEGORIA = Target.the("Campo categoría del producto")
            .located(By.id("categoria"));
    public static final Target CAMPO_SUBCATEGORIA = Target.the("Campo subcategoría del producto")
            .located(By.id("subcategoria"));
    public static final Target CAMPO_CANTIDAD = Target.the("Campo cantidad del producto")
            .located(By.id("cantidad"));
    public static final Target CAMPO_TALLA = Target.the("Campo talla del producto")
            .located(By.id("talla"));
    public static final Target CAMPO_PRECIO_VENTA = Target.the("Campo precio de venta del producto")
            .located(By.id("precio_venta"));
    public static final Target CAMPO_PRECIO_COMPRA = Target.the("Campo precio de compra del producto")
            .located(By.id("precio_compra"));
    public static final Target CAMPO_MATERIAL = Target.the("Campo material del producto")
            .located(By.id("material"));
    public static final Target CAMPO_COLOR = Target.the("Campo color del producto")
            .located(By.id("color"));
    public static final Target CAMPO_IMAGEN = Target.the("Campo imagen del producto")
            .located(By.id("imagen"));


    public static final Target BTN_GUARDAR = Target.the("Boton para registrar y guardar cambios del formulario")
            .located(By.id("submit"));

    public static final Target TABLA_PRODUCTOS = Target.the("Tabla de productos")
            .located(By.id("tablaProductos"));

    public static Target elementoProducto(String nombreProducto) {
        return Target.the("producto con nombre " + nombreProducto)
                .locatedBy("//td[contains(text(),'" + nombreProducto + "')]");
    }

    public static final Target BTN_ELIMINAR_ULTIMO = Target.the("botón eliminar del último producto en la tabla")
            .locatedBy("(//table[contains(@class,'table-striped') or contains(@class,'table-hover')]//button[contains(text(),'Eliminar')])[last()]");

    public static final Target FILAS_TABLA = Target.the("filas de la tabla de productos")
            .locatedBy("//table[contains(@class,'table-striped')]/tbody/tr");

    public static final By NOMBRE_PRODUCTO_EN_FILA = By.xpath(".//td[3]");

    public static final Target BTN_EDITAR_ULTIMO = Target.the("botón editar del último producto en la tabla")
            .locatedBy("(//table[contains(@class,'table-striped') or contains(@class,'table-hover')]//button[contains(text(),'Editar')])[last()]");

}
