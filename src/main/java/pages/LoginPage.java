package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    public WebElement emailInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//a[contains(@href, '/forgot-password')]")
    public WebElement resetPasswordLink;

    @FindBy(name = "remember")
    public WebElement rememberCheckBox;

    public void enterEmail(String email){
        this.waitElementAndSendKeys(emailInput, email);
    }

    public void enterPassword(String password){
        this.waitElementAndSendKeys(passwordInput, password);
    }

    public void clickLoginButton(){
        this.waitElementAndClick(loginButton);
    }

}
