import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class RunJquery {
    public static void main(String[] args) throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();

        webDriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        webDriver.get("http://ceng.anadolu.edu.tr/");

        webDriver.findElements(By.tagName("a"))
                .stream()
                .map(WebElement::getText)
                .filter(Objects::nonNull)
                .filter(str -> str.length()>0)
                .forEach(System.out::println);

        //Dynamic path
        webDriver.findElement(By.xpath("//input[contains(@button-renderer,'')"));

        webDriver.quit();
    }
}