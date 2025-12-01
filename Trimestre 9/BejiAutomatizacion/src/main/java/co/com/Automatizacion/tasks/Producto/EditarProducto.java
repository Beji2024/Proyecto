package co.com.Automatizacion.tasks.Producto;

import co.com.Automatizacion.interactions.Esperar;
import co.com.Automatizacion.models.Producto.DatosProducto;
import co.com.Automatizacion.userinterface.Productos.Producto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EditarProducto implements Task {

    private final DatosProducto datosProducto;

    public EditarProducto(DatosProducto datosProducto) {
        this.datosProducto = datosProducto;
    }

    public static EditarProducto conLosDatos(DatosProducto datosProducto) {
        return instrumented(EditarProducto.class, datosProducto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(Producto.BTN_EDITAR_ULTIMO),

                Clear.field(Producto.CAMPO_NOMBRE),
                Enter.theValue(datosProducto.getNombreProducto()).into(Producto.CAMPO_NOMBRE),

                SelectFromOptions.byVisibleText(datosProducto.getCategoria()).from(Producto.CAMPO_CATEGORIA),
                SelectFromOptions.byVisibleText(datosProducto.getSubcategoria()).from(Producto.CAMPO_SUBCATEGORIA),

                Clear.field(Producto.CAMPO_CANTIDAD),
                Enter.theValue(String.valueOf(datosProducto.getCantidad())).into(Producto.CAMPO_CANTIDAD),

                Clear.field(Producto.CAMPO_TALLA),
                Enter.theValue(datosProducto.getTalla()).into(Producto.CAMPO_TALLA),

                Clear.field(Producto.CAMPO_PRECIO_VENTA),
                Enter.theValue(String.valueOf(datosProducto.getPrecioVenta())).into(Producto.CAMPO_PRECIO_VENTA),

                Clear.field(Producto.CAMPO_PRECIO_COMPRA),
                Enter.theValue(String.valueOf(datosProducto.getPrecioCompra())).into(Producto.CAMPO_PRECIO_COMPRA),

                Clear.field(Producto.CAMPO_MATERIAL),
                Enter.theValue(datosProducto.getMaterial()).into(Producto.CAMPO_MATERIAL),

                Clear.field(Producto.CAMPO_COLOR),
                Enter.theValue(datosProducto.getColor()).into(Producto.CAMPO_COLOR),

                Click.on(Producto.BTN_GUARDAR),
                Esperar.segundos(10)
        );
    }
}

