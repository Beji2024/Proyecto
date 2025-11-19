package co.com.Automatizacion.tasks.venta;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class Esperar implements Task {

    private final int segundos;

    public Esperar(int segundos) {
        this.segundos = segundos;
    }

    public static Esperar segundos(int s) {
        return new Esperar(s);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
