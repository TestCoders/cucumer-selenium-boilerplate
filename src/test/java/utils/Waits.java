package utils;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Date;
import java.util.List;

public class Waits {

    public WebDriver driver;

    public Waits(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElement(WebElement element) {
        //Generic wait script which can be used for all elements.
        //If you want to wait for more than 10 seconds, you can use the function beneath this one.
       waitForElement(element, 10);
    }

    public void waitForElement(WebElement element, int seconds) {
        //Overloading of method waitForElement, when you know an element takes more then 10 seconds to load.
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (NoSuchElementException | TimeoutException | StaleElementReferenceException e) {
            //exception handling: generate clean error message
            Assert.fail("Element not found on page: " + element);
        }
    }

    public void waitForElements(List<WebElement> elementList){
        //Generic wait script which can be used for all list elements.
        //Waits for max 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try{
            wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
        } catch (NoSuchElementException | TimeoutException | StaleElementReferenceException e ){
            Assert.fail("Element not found on page: " + elementList);
        }
    }
}
