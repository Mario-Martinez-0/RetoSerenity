package is.demo.serenity.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductosUI {

    public static final Target BTN_NUEVOPORDUCTO = Target.the("click en nuevo producto")
            .locatedBy("(//div[@class='button-outer'])[1]");
    public static final Target TXT_NOMBREPRODUCTO = Target.the("ingresar nombre del producto")
            .located(By.id("Serenity_Demo_Northwind_ProductDialog9_ProductName"));

    public static final Target TXT_UNIDADESENSTOCK = Target.the("ingresar unidades disponibles")
            .located(By.id("Serenity_Demo_Northwind_ProductDialog9_UnitsInStock"));

    public static final Target TXT_UNIDADESENPEDIDO = Target.the("ingresar unidades sobre pedido")
            .located(By.id("Serenity_Demo_Northwind_ProductDialog9_UnitsOnOrder"));

    public static final Target TXT_NIVELDEREORDEN = Target.the("ingresar nivel de orden")
            .located(By.id("Serenity_Demo_Northwind_ProductDialog9_ReorderLevel"));

    public static final Target BTN_APLICARCAMBIOS = Target.the("click en aplicar cambos")
            .locatedBy("//*[@class='fa fa-clipboard-check text-purple']");

    public static final Target BTN_CERRAR = Target.the("click en Cerrar")
            .locatedBy("//button/i[@class='fa fa-times']");

    public static final Target TXT_BUSCAR = Target.the("ingresar prducto registrado")
            .locatedBy("//*[@class='s-Serenity-QuickSearchInput s-QuickSearchInput']");
    public static final Target LBL_BUSCARNOMBRE = Target.the("buscar nombre de producto")
            .locatedBy("(//a[contains(@data-item-type,'Demo.Northwind.Product')])[2]");

}