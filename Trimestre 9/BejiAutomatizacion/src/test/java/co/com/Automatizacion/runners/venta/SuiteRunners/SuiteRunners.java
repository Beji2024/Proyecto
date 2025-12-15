package co.com.Automatizacion.runners.venta.SuiteRunners;


import co.com.Automatizacion.runners.venta.CambiosRunner;
import co.com.Automatizacion.runners.venta.CrearVentaRunner;
import co.com.Automatizacion.runners.venta.DevolucionRunner;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CrearVentaRunner.class,
        CambiosRunner.class,
        DevolucionRunner.class

})
public class SuiteRunners {
}
