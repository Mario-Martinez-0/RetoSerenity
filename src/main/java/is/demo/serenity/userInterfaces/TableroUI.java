package is.demo.serenity.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class TableroUI {
    public static final Target BTN_VIENTOSDELNORTE = Target.the("click en vientos del norte")
            .locatedBy("(//span[@class='s-sidebar-link-text'])[2]");
    public static final Target BTN_PRODUCTOS = Target.the("click en productos")
            .locatedBy("(//a[@href='/Northwind/Product'])[1]");
}