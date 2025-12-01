package co.com.Automatizacion.runners.venta;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/venta/devolucion.feature",
        glue = {"co.com.Automatizacion.stepsdefinitions", "co.com.Automatizacion.utils.hooks.login"},
        plugin = {"pretty","html:target/cucumber-reports"},
        snippets = SnippetType.CAMELCASE
)
public class DevolucionesRunner {
}
