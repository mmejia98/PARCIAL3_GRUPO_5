package interfaces;

import org.openqa.selenium.WebElement;

import java.util.List;

public interface IMenu {

    String name();
    void click(List<WebElement> menuItems);

}
