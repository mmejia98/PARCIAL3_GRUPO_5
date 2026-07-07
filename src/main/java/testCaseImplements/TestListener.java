package testCaseImplements;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = BaseTestCase.driver;

        ScreenshotUtils.takeScreenshot(result.getTestClass().getName(), result.getMethod().getMethodName(), driver);
    }

}
