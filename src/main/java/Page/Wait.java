package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class Wait {
    WebDriver driver;

    public Wait(WebDriver driver) {
        this.driver = driver;
    }

    public void waitDisplay(WebElement waitValue) {
        org.openqa.selenium.support.ui.Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(12))
                .pollingEvery(Duration.ofSeconds(3));
        wait.until(w -> waitValue.isDisplayed());
    }
}
