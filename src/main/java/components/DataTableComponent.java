package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

import java.util.List;

public class DataTableComponent extends BasePage {

    public DataTableComponent(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[contains(@placeholder,'Buscar')]")
    private WebElement searchInput;

    @FindBy(xpath = "//table//tbody/tr")
    private List<WebElement> rows;

    public void search(String value){
        waitElementAndSendKeys(searchInput, value);
        waitElementAndEnter(searchInput);
    }

    public int getRowCount(){
        return rows.size();
    }

    public List<WebElement> getRows(){
        return this.rows;
    }

    public WebElement getRowContaining(String name) {
        String xpath = "//table//tbody/tr[td[contains(normalize-space(),'" + name + "')]]";
        return waitElement(By.xpath(xpath));
    }

    public void clickEdit(String name){
        String xpath = "//table//tbody/tr[td[contains(.,'" + name + "')]]//button[text()='Editar']";
        waitElementAndClick(driver.findElement(By.xpath(xpath)));
    }

    public void clickDelete(String name){
        String xpath = "//table//tbody/tr[td[contains(.,'" + name + "')]]//button[text()='Eliminar']";
        waitElementAndClick(driver.findElement(By.xpath(xpath)));
    }

    public void clickDetail(String name){
        String xpath = "//table//tbody/tr[td[contains(.,'" + name + "')]]//button[text()='Detalle']";
        waitElementAndClick(driver.findElement(By.xpath(xpath)));
    }

    public void goToPage(int page){
        String xpath = "//a[text()='" + page + "']";
        waitElementToBeClickable(driver.findElement(By.xpath(xpath)));
    }

}
