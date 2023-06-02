package is.demo.serenity.interactions;

import is.demo.serenity.utils.EscrituraExcel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

import static is.demo.serenity.userInterfaces.ProductosUI.LBL_BUSCARNOMBRE;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EnviarNuevoProductoExcel implements Interaction {

    String ProductoEnviadoExcel = "";

    @Override
    public <T extends Actor> void performAs(T actor) {

        ProductoEnviadoExcel = LBL_BUSCARNOMBRE.resolveFor(actor).getText();
        EscrituraExcel.escrituraExcel("datos/Data.xlsx", ProductoEnviadoExcel, 1, 0);

    }

    public static Performable enviarNuevoProductoExcel() {
        return instrumented(EnviarNuevoProductoExcel.class);
    }
}
