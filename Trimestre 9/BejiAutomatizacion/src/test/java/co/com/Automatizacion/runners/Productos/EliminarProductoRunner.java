package co.com.Automatizacion.runners.Productos;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/Productos/EliminarProducto.feature",
        glue = "co.com.Automatizacion.stepsdefinitions",
        plugin = {"pretty", "html:target/cucumber-reports"},
        snippets = SnippetType.CAMELCASE
)
public class EliminarProductoRunner {
}
