package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class TopMenu {
    WebDriver driver;

    public TopMenu(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickLoginButton() {
        driver.findElement(By.linkText("Sign in")).click();
        return new LoginPage(driver);
    }

    public BlogPage clickBlogButton() {
        driver.findElement(By.linkText("Blog")).click();
        return new BlogPage(driver);
    }

    public MarketplacePage clickMarketplaceButton() {
        driver.findElement(By.linkText("Marketplace")).click();
        return new MarketplacePage(driver);
    }

    public OurInitiativesPage clickOurInitiatives() {
        driver.findElement(By.xpath("//li[7]//a[@href='/our-initiatives']")).click();
        return new OurInitiativesPage(driver);
    }

    public void scroll(WebElement ScrollInto) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", ScrollInto);
    }

    public void switchTab(int numberTab) {
        Object[] windowHandle = driver.getWindowHandles().toArray();
        driver.switchTo().window(windowHandle[numberTab].toString());
    }

    public void waitDisplay(WebElement waitValue) {
        org.openqa.selenium.support.ui.Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2));
        wait.until(w -> waitValue.isDisplayed());
    }
}
