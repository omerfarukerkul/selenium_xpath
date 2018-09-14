import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class RunJquery {
    public static void main(String[] args) throws IOException {
        ChromeDriver webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();

        webDriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        webDriver.get("http://ceng.anadolu.edu.tr/");

        webDriver.findElements(By.tagName("a"))
                .stream()
                .map(WebElement::getText)
                .filter(Objects::nonNull)
                .filter(str -> str.length() > 0)
                .forEach(System.out::println);

        FileUtils.copyFile(webDriver.getScreenshotAs(OutputType.FILE), new File(System.getProperty("user.dir"), "deneme.png"));

        //Dynamic path
//        webDriver.findElement(By.xpath("//input[contains(@button-renderer,'')");
//        https://www.youtube.com/watch?v=rIFnN15nSJU&list=PLFGoYjJG_fqo4oVsa6l_V-_7-tzBnlulT&index=9

        webDriver.quit();
    }

    public static void clickOn(WebDriver webDriver, WebElement locator, int timeout) {
        new WebDriverWait(webDriver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
        locator.click();
    }
}