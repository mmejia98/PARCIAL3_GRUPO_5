package testcase_parcial3;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.InvoicePage;
import pages.LeftMenuPage;
import testCaseImplements.BaseTestCase;
import testCaseImplements.TestListener;
import utils.ScreenshotUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Listeners(TestListener.class)
public class InvoiceModuleTestCases extends BaseTestCase {

    @Test
    public void createInvoiceTestCase(){
        LeftMenuPage leftMenuPage = new LeftMenuPage(driver);
        InvoicePage invoicePage = new InvoicePage(driver);

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MMddyyyy");
        String date = LocalDateTime.now().format(formatter2);
        String numInvoice = "NPE-TEST-" + LocalDateTime.now().format(formatter1);
        String branch = "Casa Matriz";
        String seller = "Evelyn Carroll";
        String product = "6595 - iphone";
        String quantity = "3";

        LeftMenuPage.Menu.VENTAS_FACTURAS.click(leftMenuPage.getMenuItems());
        invoicePage.clickCreateInvoiceButton();
        invoicePage.enterDate(date);
        invoicePage.enterNumberInvoice(numInvoice);
        invoicePage.getSelectBranchInput().selectByText(branch);
        invoicePage.getSelectSellerInput().selectByText(seller);
        invoicePage.getSelectProductInput().selectByText(product);
        invoicePage.enterCountProduct(quantity);
        invoicePage.clickSaveInvoiceButton();
        invoicePage.searchInvoice(numInvoice);

        Assert.assertTrue(invoicePage.isInvoicePresentOnDatatable(numInvoice));

        ScreenshotUtils.takeScreenshot(this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(),  driver);

    }

    @Test
    public void validateRequiredFilesFromInvoiceFormTestCase(){
        LeftMenuPage leftMenuPage = new LeftMenuPage(driver);
        InvoicePage invoicePage = new InvoicePage(driver);

        String date = "01012026";
        String branch = "Casa Matriz";
        String seller = "Evelyn Carroll";
        String product = "6595 - iphone";
        String quantity = "3";
        String unitPrice = "2";

        LeftMenuPage.Menu.VENTAS_FACTURAS.click(leftMenuPage.getMenuItems());

        //validar campo obligatorio: Fecha
        invoicePage.clickCreateInvoiceButton();
        invoicePage.getSelectBranchInput().selectByText(branch);
        invoicePage.getSelectSellerInput().selectByText(seller);
        invoicePage.getSelectProductInput().selectByText(product);
        invoicePage.enterCountProduct(quantity);
        invoicePage.enterUnitPrice(unitPrice);
        invoicePage.clickSaveInvoiceButton();
        Assert.assertEquals(invoicePage.getValidationText(), "The fecha de compra field is required.");
        ScreenshotUtils.takeScreenshot(this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), driver);
        driver.navigate().refresh();

        //validar campo obligatorio: Sucursal
        invoicePage.clickCreateInvoiceButton();
        invoicePage.enterDate(date);
        invoicePage.getSelectSellerInput().selectByText(seller);
        invoicePage.getSelectProductInput().selectByText(product);
        invoicePage.enterCountProduct(quantity);
        invoicePage.enterUnitPrice(unitPrice);
        invoicePage.clickSaveInvoiceButton();
        Assert.assertEquals(invoicePage.getValidationText(), "The sucursal field is required.");
        ScreenshotUtils.takeScreenshot(this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), driver);
        driver.navigate().refresh();

        //validar campo obligatorio: Vendedor
        invoicePage.clickCreateInvoiceButton();
        invoicePage.enterDate(date);
        invoicePage.getSelectBranchInput().selectByText(branch);
        invoicePage.getSelectProductInput().selectByText(product);
        invoicePage.enterCountProduct(quantity);
        invoicePage.enterUnitPrice(unitPrice);
        invoicePage.clickSaveInvoiceButton();
        Assert.assertEquals(invoicePage.getValidationText(), "The vendedor field is required.");
        ScreenshotUtils.takeScreenshot(this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), driver);
        driver.navigate().refresh();

        //validar campo obligatorio: Producto
        invoicePage.clickCreateInvoiceButton();
        invoicePage.enterDate(date);
        invoicePage.getSelectBranchInput().selectByText(branch);
        invoicePage.getSelectSellerInput().selectByText(seller);
        invoicePage.enterCountProduct(quantity);
        invoicePage.enterUnitPrice(unitPrice);
        invoicePage.clickSaveInvoiceButton();
        Assert.assertEquals(invoicePage.getValidationText(), "The producto field is required.");
        ScreenshotUtils.takeScreenshot(this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), driver);

    }

}
