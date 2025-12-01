package co.com.Automatizacion.runners.venta.SuiteRunners;


import co.com.Automatizacion.runners.Productos.CrearProductoRunner;
import co.com.Automatizacion.runners.Productos.EliminarProductoRunner;
import co.com.Automatizacion.runners.venta.CambiosRunner;
import co.com.Automatizacion.runners.venta.ConsultarVentaRunner;
import co.com.Automatizacion.runners.venta.CrearVentaRunner;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ConsultarVentaRunner.class,
        CrearVentaRunner.class,
        CambiosRunner.class

})
public class SuiteRunners {
}
