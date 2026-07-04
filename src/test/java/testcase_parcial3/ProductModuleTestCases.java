package testcase_parcial3;

import org.testng.annotations.Test;
import pages.LeftMenuPage;
import pages.ProductPage;
import testCaseImplements.BaseTestCase;

public class ProductModuleTestCases extends BaseTestCase {

    @Test
    public void createProductTestCase(){
        LeftMenuPage leftMenuPage = new LeftMenuPage(driver);
        ProductPage productPage = new ProductPage(driver);

        LeftMenuPage.Menu.PRODUCTOS.click(leftMenuPage.getMenuItems());
    }

}
