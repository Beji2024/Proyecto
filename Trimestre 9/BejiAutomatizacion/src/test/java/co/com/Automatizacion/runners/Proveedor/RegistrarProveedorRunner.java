package co.com.Automatizacion.runners.Proveedor;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/RegistrarProveedor.feature",
        glue = "co.com.Automatizacion.stepsdefinitions",
        snippets = SnippetType.CAMELCASE,
        plugin = {"pretty", "html:target/cucumber-reports/registrar"},
        tags = "@RegistrarProveedor"
)
public class RegistrarProveedorRunner {
}
