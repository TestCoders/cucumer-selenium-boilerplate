package utils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtils {

    public void addScreenshot(Scenario scenario, WebDriver driver) throws IOException {
        String nameScreenshot = "screenshot_" + createScreenshotFileName();
        String targetPath = new File("..\\boilerplate\\output\\" + nameScreenshot).getCanonicalPath();

        //If scenario fails, add a screenshot to the report
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png", nameScreenshot); //stick it in the report
                try {
                    File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                    org.apache.commons.io.FileUtils.copyFile(screenshotFile, new File(targetPath));
                } catch (IOException e) {
                    System.out.println("Error Error Error");
                }
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }
        }
    }

    public String createScreenshotFileName(){

        final StringBuilder sb = new StringBuilder();
        final DateFormat dateformat = new SimpleDateFormat("yyyyMMdd-HHmmss");
        final java.lang.String timestamp = dateformat.format(new Date());
        sb.append(timestamp).append(".png");
        return sb.toString();

    }
}
