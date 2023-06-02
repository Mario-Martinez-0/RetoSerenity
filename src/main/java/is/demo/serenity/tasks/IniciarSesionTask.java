package is.demo.serenity.tasks;

import is.demo.serenity.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static is.demo.serenity.userInterfaces.InicioSesionUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IniciarSesionTask implements Task {

    ArrayList<Map<String, String>> datosExcel = new ArrayList<>();

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            datosExcel = Excel.leerDatosDeHojaDeExcel("datos/Data.xlsx", "InicioSesion");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        actor.attemptsTo(
                Enter.theValue(datosExcel.get(0).get("NombreUsuario")).into(TXT_USUARIO),
                Enter.theValue(datosExcel.get(0).get("Clave")).into(TXT_CLAVE),
                Click.on(BTN_INICIOSESION)
        );

    }

    public static Performable iniciarSesionTask() {
        return instrumented(IniciarSesionTask.class);
    }
}
