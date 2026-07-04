package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

import java.util.List;
import java.util.stream.Collectors;

public class ComboBoxComponent extends BasePage {

    private final By locator;

    public ComboBoxComponent(WebDriver driver, By locator) {
        super(driver);
        this.locator = locator;
    }

    private Select getSelect(){
        WebElement element = waitElement(locator);
        return new Select(element);
    }

    public void selectByText(String text) {
        getSelect().selectByVisibleText(text);
    }

    public void selectByValue(String value) {
        getSelect().selectByValue(value);
    }

    public void selectByIndex(int index) {
        getSelect().selectByIndex(index);
    }

    public String getSelectedText() {
        return getSelect()
                .getFirstSelectedOption()
                .getText();
    }

    public List<String> getOptions() {
        return getSelect()
                .getOptions()
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public boolean containsOption(String text) {
        return getOptions().contains(text);
    }

}
