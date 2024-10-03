package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class BasePage {

    public WebDriver driver;
    public Wait<WebDriver> wait;

    public void BasePage(){
        System.out.println("=== BasePage init with empty param ===");
    }

    public void BasePage(WebDriver driver) {
        System.out.println("=== BasePage init with driver ===");
        this.driver = driver;
        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500));
    }

    public void waitForElementDisplay(String locator) {
        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500));
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(locator))));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
}
