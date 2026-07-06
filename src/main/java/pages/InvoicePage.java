package pages;

import components.ComboBoxComponent;
import components.DataTableComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvoicePage extends BasePage{

    private final DataTableComponent dataTable;

    private final ComboBoxComponent selectBranchInput;

    private final ComboBoxComponent selectSellerInput;

    private final ComboBoxComponent selectProductInput;

    public InvoicePage(WebDriver driver) {
        super(driver);
        dataTable = new DataTableComponent(driver);
        selectBranchInput = new ComboBoxComponent(driver, By.xpath("/html/body/div[2]/div[2]/div/div[2]/form/div[1]/label[3]/select"));
        selectSellerInput = new ComboBoxComponent(driver, By.xpath("/html/body/div[2]/div[2]/div/div[2]/form/div[1]/label[4]/select"));
        selectProductInput = new ComboBoxComponent(driver, By.xpath("/html/body/div[2]/div[2]/div/div[2]/form/div[2]/div[2]/label[1]/select"));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/main/div[1]/button")
    private WebElement createInvoiceButton;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div[2]/form/div[1]/label[1]/input")
    private WebElement dateInput;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div[2]/form/div[1]/label[2]/input")
    private WebElement numberInvoiceInput;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div[2]/form/div[2]/div[1]/button")
    private WebElement addProductButton;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div[2]/form/div[2]/div[2]/label[2]/input")
    private WebElement countProductInput;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div[2]/form/div[2]/div[2]/label[3]/div/input")
    private WebElement unitPriceInput;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div[2]/form/button")
    private WebElement saveInvoiceButton;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div")
    private WebElement invoiceForm;

    public void clickCreateInvoiceButton(){
        this.waitElementAndClick(createInvoiceButton);
    }

    public void enterDate(String date){
        this.waitElementAndSendKeys(dateInput, date);
    }

    public void enterNumberInvoice(String number){
        this.waitElementAndSendKeys(numberInvoiceInput, number);
    }

    public void enterCountProduct(String count){
        this.waitElementAndSendKeys(countProductInput, count);
    }

    public void enterUnitPrice(String unit){
        this.waitElementAndSendKeys(unitPriceInput, unit);
    }

    public void clickSaveInvoiceButton(){
        this.waitElementAndClick(saveInvoiceButton);
    }

    public DataTableComponent getDataTable(){
        return dataTable;
    }

    public ComboBoxComponent getSelectBranchInput(){
        return selectBranchInput;
    }

    public ComboBoxComponent getSelectSellerInput(){
        return selectSellerInput;
    }

    public ComboBoxComponent getSelectProductInput(){
        return selectProductInput;
    }

    public void searchInvoice(String text){
        waitElementToBeInvisible(invoiceForm);
        dataTable.search(text);
    }

    public boolean isInvoicePresentOnDatatable(String numInvoice){
        WebElement row = dataTable.getRowContaining(numInvoice);
        return row.isDisplayed();
    }

    public String getValidationText(){
        String xpath = "//span[contains(@class,'text-red-500')]" ;
        return waitElement(By.xpath(xpath)).getText();
    }

}
