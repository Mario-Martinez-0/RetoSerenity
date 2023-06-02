package is.demo.serenity.stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import is.demo.serenity.interactions.EnviarNuevoProductoExcel;
import is.demo.serenity.questions.ValidacionNombreProductoQuestion;
import is.demo.serenity.tasks.BuscarProductoTask;
import is.demo.serenity.tasks.IngresarProductosTask;
import is.demo.serenity.tasks.IniciarSesionTask;
import is.demo.serenity.tasks.SeleccionarMenuProductosTask;
import is.demo.serenity.utils.Excel;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class IngresarProductoStepDefinition {

    @Before
    public void setStage() {
        setTheStage(new OnlineCast());
    }

    @Dado("que el usuario abre la url en el navegador")
    public void queElUsuarioAbreLaUrlEnElNavegador() throws IOException {
        ArrayList<Map<String, String>> datosExcel = Excel.leerDatosDeHojaDeExcel("datos/Data.xlsx", "Url");
        String url = datosExcel.get(0).get("Url");
        theActorCalled("Usuario").wasAbleTo(Open.url(url));
    }

    @Cuando("El usuario inicia sesion con sus credenciales")
    public void elUsuarioIniciaSesionConSusCredenciales() {
        theActorInTheSpotlight().attemptsTo(
                IniciarSesionTask.iniciarSesionTask());
    }

    @Cuando("da clic en vientos del norte y clic en producto")
    public void daClicEnVientosDelNorteYClicEnProducto() {
        theActorInTheSpotlight().attemptsTo(
                SeleccionarMenuProductosTask.seleccionarMenuProductosTask());
    }

    @Cuando("damos clic en nuevo producto llenamos los campos y clic en guardar")
    public void damosClicEnNuevoProductoLlenamosLosCamposYClicEnGuardar() {
        theActorInTheSpotlight().attemptsTo(
                IngresarProductosTask.ingresarProductosTask(),
                BuscarProductoTask.buscarProductoTask());
    }

    @Entonces("El usuario visualizara el nombre del nuevo producto")
    public void elUsuarioVisualizaraElNombreDelNuevoProducto() {
        theActorInTheSpotlight().should(seeThat(
                "Se visualiza el nuevo producto",
                ValidacionNombreProductoQuestion.validacionNombreProductoQuestion(),
                Matchers.equalTo(true))
        );
    }

    @Entonces("se envia el nombre del nuevo producto a excel")
    public void seenviaelnombredelnuevoproductoaexcel() {
        theActorInTheSpotlight().attemptsTo(
                EnviarNuevoProductoExcel.enviarNuevoProductoExcel());
    }
}