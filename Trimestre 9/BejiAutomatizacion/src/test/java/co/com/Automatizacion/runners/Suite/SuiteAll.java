package co.com.Automatizacion.runners.Suite;
import co.com.Automatizacion.runners.Productos.Suite.SuiteProductos;
import co.com.Automatizacion.runners.Proveedor.Suite.SuiteProveedor;
import co.com.Automatizacion.runners.Usuarios.Suite.SuiteUsuarios;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        SuiteProveedor.class,
        SuiteProductos.class,
        SuiteUsuarios.class

})
public class SuiteAll {
}
