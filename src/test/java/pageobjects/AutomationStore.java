package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AutomationStore {

    public AutomationStore(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "img[class^='logo']")
    public WebElement logoStore;

    @FindBy(css = "a[title='Women']")
    public WebElement menuCategoryWomen;

    @FindBy(css = "a[title='Women'] ~ ul  a")
    public List<WebElement> dropdownItemsCategoryWomen;
}
