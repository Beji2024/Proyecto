package co.com.Automatizacion.interactions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
public  class ScrollBottom  implements Task{
    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        Actions actions = new Actions(driver);

        // Realiza múltiples "PAGE_DOWN" hasta el final
        for (int i = 0; i < 10; i++) {
            actions.sendKeys(org.openqa.selenium.Keys.PAGE_DOWN).perform();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
            public static ScrollBottom completo() {
                return instrumented(ScrollBottom.class);
            }
        }

