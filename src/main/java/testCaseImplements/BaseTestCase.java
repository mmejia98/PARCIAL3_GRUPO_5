package testCaseImplements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

import java.time.Duration;

public abstract class BaseTestCase {

    protected static WebDriver driver;

    @BeforeClass
    public static void beforeClass() {
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();
        driver.get("http://3.144.42.175/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("super@tdc.com");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();
    }

    @BeforeMethod
    public void beforeMethod() {

    }

    @AfterClass
    public static void afterClass() {
        //driver.close();
    }

}
