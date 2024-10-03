package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class TopMenu extends BasePage{
//    WebDriver driver;
//
    public TopMenu(WebDriver driver) {
        super();
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


}
