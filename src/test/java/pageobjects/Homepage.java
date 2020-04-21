package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

    public Homepage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "logo_homepage_link")
    public WebElement logoHomepage;

    @FindBy(css = "#search_form_input_homepage")
    public WebElement searchBar;

    @FindBy(id = "search_button_homepage")
    public WebElement searchButton;

}
