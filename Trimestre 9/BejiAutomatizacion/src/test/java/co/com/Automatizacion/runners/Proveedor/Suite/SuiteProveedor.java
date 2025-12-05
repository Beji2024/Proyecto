package co.com.Automatizacion.runners.Proveedor.Suite;
import co.com.Automatizacion.runners.Proveedor.RegistrarProveedorRunner;
import co.com.Automatizacion.runners.Proveedor.EditarProveedorRunner;
import co.com.Automatizacion.runners.Proveedor.EliminarProveedorRunner;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        RegistrarProveedorRunner.class,
        EditarProveedorRunner.class,
        EliminarProveedorRunner.class,
})
public class SuiteProveedor {
}
