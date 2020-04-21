package utils;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.List;

public class Validations {

    public WebDriver driver;

    public Validations(WebDriver driver){
        this.driver = driver;
    }

    public void compareOptionsDropDown(WebElement element, List<String> listExpected){
        //Specifically made for Select-elements

        Select list = new Select(element);

        List<WebElement> actualOptions = list.getOptions();
        List<String> actualOptionsText = new ArrayList<>();
        ArrayList<String> results = new ArrayList<>();

        for(WebElement option : actualOptions){
            actualOptionsText.add(option.getText());
        }

        //Verify both list have the same length to make sure there are no extra items or too few items in one of the lists
        Assert.assertEquals("The size of the expected dropdownlist is not equal to the size of the actual dropdownlist", listExpected.size(), actualOptionsText.size());

        for(String listItem : listExpected){
            if(actualOptionsText.contains(listItem)){
                //If the expected list item is present in the actual list, add 'true'
                results.add("true");
            } else {
                //if the expected list item cannot be found in the actual list, add 'false'
                results.add("false");
                System.out.println("Houston we have a problem! " + listItem + " is not present in de list!");
            }
        }
        //If the list containing the results only contains 'true' all items in the actual list match an item in the expected list
        Assert.assertFalse("Expected dropdownlist does not match actual dropdownlist", results.contains("false"));
    }

    public  void compareLists(List<WebElement> element, List<String> lijstExpected){

        List<String> actualList = new ArrayList<>();
        ArrayList<String> results = new ArrayList<>();

        for(WebElement expectedListItem : element){
            System.out.println("Found label: " + expectedListItem.getText());
            List<WebElement> children = expectedListItem.findElements(By.cssSelector("*"));
            String labeltext = expectedListItem.getText();
            if(labeltext.contains("Geboortedatum")){
                for (WebElement child : children){
                    labeltext = labeltext.replace(child.getText(), "");
                }
            }
            actualList.add(labeltext.trim());
        }

        for(String labelExpected : lijstExpected){
            if(actualList.contains(labelExpected)){
                results.add("true");
            } else {
                results.add("false");
                System.out.println("Error!!! " + labelExpected + " komt niet voor in de lijst!!");
            }
        }

        Assert.assertFalse("Werkelijke lijst " + actualList +" komt niet overeen met gevonden lijst: " + lijstExpected, results.contains("false"));
    }
}
