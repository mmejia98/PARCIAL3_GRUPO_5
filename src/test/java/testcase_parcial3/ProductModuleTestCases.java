package testcase_parcial3;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LeftMenuPage;
import pages.ProductPage;
import testCaseImplements.BaseTestCase;
import utils.ScreenshotUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProductModuleTestCases extends BaseTestCase {

    @Test
    public void createProductTestCase(){
        LeftMenuPage leftMenuPage = new LeftMenuPage(driver);
        ProductPage productPage = new ProductPage(driver);

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MMddyyyy");
        String codeProduct = "TEST-" + LocalDateTime.now().format(formatter1);
        String productName = "Producto de prueba automatizada";
        String provider = "Carlos";
        String originCountry = "El Salvador";
        String unitPrice = "52.62";
        String purchaseDate = LocalDateTime.now().format(formatter2);
        String batchNumber = "Test-123456";

        LeftMenuPage.Menu.PRODUCTOS.click(leftMenuPage.getMenuItems());
        productPage.clickCreateProductButton();
        productPage.enterProductCode(codeProduct);
        productPage.enterProductName(productName);
        productPage.getSelectProviderInput().selectByText(provider);
        productPage.getSelectOriginCountryInput().selectByText(originCountry);
        productPage.enterUnitPrice(unitPrice);
        productPage.enterPurchaseDate(purchaseDate);
        productPage.enterBatchNumber(batchNumber);
        productPage.clickSaveProductButton();
        productPage.searchProduct(codeProduct);

        Assert.assertTrue(productPage.isProductPresentOnDatatable(codeProduct));

        ScreenshotUtils.takeScreenshot(this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), driver);
    }

    @Test
    public void validateRequiredFilesFromProductFormTestCase(){
        LeftMenuPage leftMenuPage = new LeftMenuPage(driver);
        ProductPage productPage = new ProductPage(driver);

        String codeProduct = "TEST-PRUEBA12312";
        String productName = "Producto de prueba automatizada";
        String provider = "Carlos";
        String originCountry = "El Salvador";
        String unitPrice = "52.62";
        String purchaseDate = "05072026";
        String batchNumber = "Test-123456";

        LeftMenuPage.Menu.PRODUCTOS.click(leftMenuPage.getMenuItems());

        //validar campo obligatorio: Codigo de producto
        productPage.clickCreateProductButton();
        productPage.enterProductName(productName);
        productPage.getSelectProviderInput().selectByText(provider);
        productPage.getSelectOriginCountryInput().selectByText(originCountry);
        productPage.enterUnitPrice(unitPrice);
        productPage.enterPurchaseDate(purchaseDate);
        productPage.enterBatchNumber(batchNumber);
        productPage.clickSaveProductButton();
        Assert.assertEquals(productPage.getValidationText(), "The código del producto field is required.");
        ScreenshotUtils.takeScreenshot(this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), driver);
        driver.navigate().refresh();

        //validar campo obligatorio: Nombre
        productPage.clickCreateProductButton();
        productPage.enterProductCode(codeProduct);
        productPage.getSelectProviderInput().selectByText(provider);
        productPage.getSelectOriginCountryInput().selectByText(originCountry);
        productPage.enterUnitPrice(unitPrice);
        productPage.enterPurchaseDate(purchaseDate);
        productPage.enterBatchNumber(batchNumber);
        productPage.clickSaveProductButton();
        Assert.assertEquals(productPage.getValidationText(), "The nombre del producto field is required.");
        ScreenshotUtils.takeScreenshot(this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), driver);
        driver.navigate().refresh();

        //validar campo obligatorio: Proveedor
        productPage.clickCreateProductButton();
        productPage.enterProductCode(codeProduct);
        productPage.enterProductName(productName);
        productPage.getSelectOriginCountryInput().selectByText(originCountry);
        productPage.enterUnitPrice(unitPrice);
        productPage.enterPurchaseDate(purchaseDate);
        productPage.enterBatchNumber(batchNumber);
        productPage.clickSaveProductButton();
        Assert.assertEquals(productPage.getValidationText(), "The proveedor field is required.");
        ScreenshotUtils.takeScreenshot(this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), driver);
        driver.navigate().refresh();

        //validar campo obligatorio: País de origen
        productPage.clickCreateProductButton();
        productPage.enterProductCode(codeProduct);
        productPage.enterProductName(productName);
        productPage.getSelectProviderInput().selectByText(provider);
        productPage.enterUnitPrice(unitPrice);
        productPage.enterPurchaseDate(purchaseDate);
        productPage.enterBatchNumber(batchNumber);
        productPage.clickSaveProductButton();
        Assert.assertEquals(productPage.getValidationText(), "The país de origen field is required.");
        ScreenshotUtils.takeScreenshot(this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), driver);
    }

}
