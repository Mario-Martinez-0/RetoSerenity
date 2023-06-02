package is.demo.serenity.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static is.demo.serenity.userInterfaces.TableroUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarMenuProductosTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Click.on(BTN_VIENTOSDELNORTE),
                Click.on(BTN_PRODUCTOS)
        );
    }

    public static Performable seleccionarMenuProductosTask() {
        return instrumented(SeleccionarMenuProductosTask.class);
    }
}
