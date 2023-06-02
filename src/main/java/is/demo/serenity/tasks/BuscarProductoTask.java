package is.demo.serenity.tasks;

import is.demo.serenity.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static is.demo.serenity.userInterfaces.ProductosUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BuscarProductoTask implements Task {

    ArrayList<Map<String, String>> datosExcel = new ArrayList<>();

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            datosExcel = Excel.leerDatosDeHojaDeExcel("datos/Data.xlsx", "DatosNuevoProducto");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        actor.attemptsTo(
                Enter.theValue(datosExcel.get(0).get("NombreProducto")).into(TXT_BUSCAR).thenHit(Keys.ENTER)
        );

    }

    public static Performable buscarProductoTask() {
        return instrumented(BuscarProductoTask.class);
    }
}