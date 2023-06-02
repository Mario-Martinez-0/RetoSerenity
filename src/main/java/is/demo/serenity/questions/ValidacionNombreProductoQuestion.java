package is.demo.serenity.questions;

import is.demo.serenity.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static is.demo.serenity.userInterfaces.ProductosUI.*;

public class ValidacionNombreProductoQuestion implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        String name = "";

        try {
            ArrayList<Map<String, String>> excelData = Excel.leerDatosDeHojaDeExcel("datos/Data.xlsx", "DatosNuevoProducto");
            name = excelData.get(0).get("NombreProducto");

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        String nombreProducto = LBL_BUSCARNOMBRE.resolveFor(actor).getText();
        return name.equals(nombreProducto);
    }

    public static Question validacionNombreProductoQuestion() {
        return new ValidacionNombreProductoQuestion();
    }
}




