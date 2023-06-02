package is.demo.serenity.tasks;

import is.demo.serenity.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static is.demo.serenity.userInterfaces.ProductosUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IngresarProductosTask implements Task {

    ArrayList<Map<String, String>> datosExcel = new ArrayList<>();

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            datosExcel = Excel.leerDatosDeHojaDeExcel("datos/Data.xlsx", "DatosNuevoProducto");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        actor.attemptsTo(
                Click.on(BTN_NUEVOPORDUCTO),
                Enter.theValue(datosExcel.get(0).get("NombreProducto")).into(TXT_NOMBREPRODUCTO),
                Enter.theValue(datosExcel.get(0).get("UnidadesDisponibles")).into(TXT_UNIDADESENSTOCK),
                Enter.theValue(datosExcel.get(0).get("UnidadesSobrePedido")).into(TXT_UNIDADESENPEDIDO),
                Enter.theValue(datosExcel.get(0).get("NivelDeOrden")).into(TXT_NIVELDEREORDEN),
                Click.on(BTN_APLICARCAMBIOS),
                Click.on(BTN_CERRAR)
        );
    }

    public static Performable ingresarProductosTask() {
        return instrumented(IngresarProductosTask.class);
    }
}