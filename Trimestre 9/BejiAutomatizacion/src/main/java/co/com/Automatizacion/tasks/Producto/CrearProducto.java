package co.com.Automatizacion.tasks.Producto;

import co.com.Automatizacion.models.Producto.DatosProducto;
import co.com.Automatizacion.userinterface.Productos.Producto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
<<<<<<< HEAD
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
=======
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Paths;

import static net.serenitybdd.screenplay.Tasks.instrumented;
>>>>>>> 18e8930b7b9e2bfa3724a8a7e49dfff8973d0548

public class CrearProducto implements Task {

    private final DatosProducto datosProducto;

    public CrearProducto(DatosProducto datosProducto) {
        this.datosProducto = datosProducto;
    }

    public static CrearProducto conLosDatos(DatosProducto datosProducto) {
        return instrumented(CrearProducto.class, datosProducto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

<<<<<<< HEAD
        actor.attemptsTo(
                Click.on(Producto.BTN_PRODUCTO),
                Click.on(Producto.BTN_MASOPCIONES),
                Click.on(Producto.BTN_GESTIONARPRODUCTOS)
        );


        try {
            Thread.sleep(90000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        actor.attemptsTo(
                WaitUntil.the(Producto.BTN_NUEVOPRODUCTO, isVisible()).forNoMoreThan(15).seconds(),
                WaitUntil.the(Producto.BTN_NUEVOPRODUCTO, isEnabled()).forNoMoreThan(15).seconds(),
                Click.on(Producto.BTN_NUEVOPRODUCTO),

=======
        String rutaImagen = Paths.get("src/test/resources/Imagenes/" + datosProducto.getImagen())
                .toAbsolutePath().toString();
        File archivo = new File(rutaImagen);
        if (!archivo.exists()) {
            throw new RuntimeException("No se encontró la imagen en: " + rutaImagen);
        }

        actor.attemptsTo(
                co.com.Automatizacion.tasks.venta.Esperar.segundos(15),
                Click.on(Producto.BTN_NUEVOPRODUCTO),
>>>>>>> 18e8930b7b9e2bfa3724a8a7e49dfff8973d0548
                Enter.theValue(datosProducto.getNombreProducto()).into(Producto.CAMPO_NOMBRE),
                SelectFromOptions.byVisibleText(datosProducto.getCategoria()).from(Producto.CAMPO_CATEGORIA),
                SelectFromOptions.byVisibleText(datosProducto.getSubcategoria()).from(Producto.CAMPO_SUBCATEGORIA),
                Enter.theValue(String.valueOf(datosProducto.getCantidad())).into(Producto.CAMPO_CANTIDAD),
                Enter.theValue(String.valueOf(datosProducto.getTalla())).into(Producto.CAMPO_TALLA),
                Enter.theValue(String.valueOf(datosProducto.getPrecioVenta())).into(Producto.CAMPO_PRECIO_VENTA),
                Enter.theValue(String.valueOf(datosProducto.getPrecioCompra())).into(Producto.CAMPO_PRECIO_COMPRA),
                Enter.theValue(datosProducto.getMaterial()).into(Producto.CAMPO_MATERIAL),
                Enter.theValue(datosProducto.getColor()).into(Producto.CAMPO_COLOR),
<<<<<<< HEAD
=======
                Enter.keyValues(rutaImagen).into(Producto.CAMPO_IMAGEN),
>>>>>>> 18e8930b7b9e2bfa3724a8a7e49dfff8973d0548
                Click.on(Producto.BTN_GUARDAR)
        );
    }
}

<<<<<<< HEAD
=======

>>>>>>> 18e8930b7b9e2bfa3724a8a7e49dfff8973d0548
