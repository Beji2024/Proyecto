package co.com.Automatizacion.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/Proveedores.feature",
        glue = {"co.com.Automatizacion.stepsdefinitions"},
        snippets = SnippetType.CAMELCASE
)
public class RegistrarProveedorRunner {
}