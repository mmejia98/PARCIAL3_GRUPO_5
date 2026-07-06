package pages;

import components.ComboBoxComponent;
import components.DataTableComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage {

    private final DataTableComponent dataTable;

    private final ComboBoxComponent selectProviderInput;

    private final ComboBoxComponent selectOriginCountryInput;

    public ProductPage(WebDriver driver) {
        super(driver);
        dataTable = new DataTableComponent(driver);
        selectProviderInput = new ComboBoxComponent(driver, By.xpath("/html/body/div[2]/div[2]/div/div[2]/form/label[3]/select"));
        selectOriginCountryInput = new ComboBoxComponent(driver, By.xpath("/html/body/div[2]/div[2]/div/div[2]/form/label[4]/select"));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/main/div[1]/button")
    private WebElement createProductButton;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div[2]/form/label[1]/input")
    private WebElement productCodeInput;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div[2]/form/label[2]/input")
    private WebElement productNameInput;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div[2]/form/label[5]/input")
    private WebElement unitPriceInput;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div[2]/form/label[6]/input")
    private WebElement purchaseDateInput;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div[2]/form/label[7]/input")
    private WebElement batchNumberInput;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div[2]/form/button")
    private WebElement saveProductButton;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div")
    private WebElement productForm;

    public void clickCreateProductButton(){
        this.waitElementAndClick(createProductButton);
    }

    public void enterProductCode(String code){
        this.waitElementAndSendKeys(productCodeInput, code);
    }

    public void enterProductName(String name){
        this.waitElementAndSendKeys(productNameInput, name);
    }

    public void enterUnitPrice(String price){
        this.waitElementAndSendKeys(unitPriceInput, price);
    }

    public void enterPurchaseDate(String date){
        this.waitElementAndSendKeys(purchaseDateInput, date);
    }

    public void enterBatchNumber(String number){
        this.waitElementAndSendKeys(batchNumberInput, number);
    }

    public void clickSaveProductButton(){
        this.waitElementAndClick(saveProductButton);
    }

    public DataTableComponent getDataTable(){
        return dataTable;
    }

    public ComboBoxComponent getSelectProviderInput(){
        return selectProviderInput;
    }

    public ComboBoxComponent getSelectOriginCountryInput(){
        return selectOriginCountryInput;
    }

    public void searchProduct(String text){
        waitElementToBeInvisible(productForm);
        dataTable.search(text);
    }

    public boolean isProductPresentOnDatatable(String code){
        WebElement row = dataTable.getRowContaining(code);
        return row.isDisplayed();
    }

    public String getValidationText(){
        String xpath = "//span[contains(@class,'text-red-500')]" ;
        return waitElement(By.xpath(xpath)).getText();
    }

}
