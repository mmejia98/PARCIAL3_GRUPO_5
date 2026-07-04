package pages;

import interfaces.IMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LeftMenuPage extends BasePage {

    public LeftMenuPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[1]/main/nav/div/a")
    private List<WebElement> menuItems;

    public List<WebElement> getMenuItems(){
        return waitElements(this.menuItems);
    }

    public enum Menu implements IMenu {
        DASHBOARD("DASHBOARD"),
        USUARIOS("USUARIOS"),
        ROLES("ROLES"),
        SUCURSALES_VENDEDORES("SUCURSALES/VENDEDORES"),
        PROVEEDORES("PROVEEDORES"),
        PRODUCTOS("PRODUCTOS"),
        CLIENTES("CLIENTES"),
        VENTAS_FACTURAS("VENTAS / FACTURAS"),
        INFORMES_GERENCIALES("INFORMES GERENCIALES");

        private String name;

        Menu(String name) {
            this.name = name;
        }

        @Override
        public void click(List<WebElement> menuItems) {
            for (WebElement menuItem : menuItems) {
                String text = menuItem.getText();
                if(this.name.contains(menuItem.getText().trim())){
                    menuItem.click();
                    break;
                }
            }
        }
    }

}
