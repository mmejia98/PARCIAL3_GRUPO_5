package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/main/div[1]/button")
    public WebElement createProductButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/main/div[2]/input")
    public WebElement searchProductInput;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div[2]/form/label[1]/input")
    public WebElement productCodeInput;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div[2]/form/label[2]/input")
    public WebElement productNameInput;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div[2]/form/label[3]/select")
    public WebElement selectProviderInput;

}
