package is.demo.serenity.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InicioSesionUI {

    public static final Target TXT_USUARIO = Target.the("Ingresar nombre de usuario ")
            .located (By.id("LoginPanel0_Username"));

    public static final Target TXT_CLAVE = Target.the("Ingresar clave de usurio")
            .located (By.id("LoginPanel0_Password"));

    public static final Target BTN_INICIOSESION= Target.the("Clic en inciar sesion")
            .located (By.id("LoginPanel0_LoginButton"));

}