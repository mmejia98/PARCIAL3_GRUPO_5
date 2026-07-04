package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ScreenshotUtils {

    public static void takeScreenshot(String classname, String testCaseName, WebDriver driver) {
        if(driver instanceof TakesScreenshot){
            File screenshot =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            new File("./target/images/"+classname+"/"+testCaseName).mkdir();

            try{
                FileUtils.copyFileToDirectory(screenshot, new File("./target/images/"+classname+"/"+testCaseName));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
