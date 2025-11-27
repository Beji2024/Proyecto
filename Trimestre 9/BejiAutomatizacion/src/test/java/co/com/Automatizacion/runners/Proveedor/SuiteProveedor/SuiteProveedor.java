package co.com.Automatizacion.runners.Proveedor.SuiteProveedor;

import co.com.Automatizacion.runners.Proveedor.EditarProveedorRunner;
import co.com.Automatizacion.runners.Proveedor.EliminarProveedorRunner;
import co.com.Automatizacion.runners.Proveedor.RegistrarProveedorRunner;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        RegistrarProveedorRunner.class,
        EditarProveedorRunner.class,
        EliminarProveedorRunner.class

})

public class SuiteProveedor {
}
