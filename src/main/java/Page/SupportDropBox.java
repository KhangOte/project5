package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class SupportDropBox {
    WebDriver driver;
    @FindBy(xpath = "//div[@id = 'support-dropdown']")
    WebElement supportDropDown;
    @FindBy(xpath = "//ul[@class = 'dropdown-menu dropdown-visible']/li[3]/a")
    WebElement chatBotFunc;
    @FindBy(xpath = "//div//input[@class = 'w-full rounded border py-2 pl-4 pr-10 shadow focus:outline-none']")
    WebElement chatBox;

    public SupportDropBox(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void chatBot(String q1, String q2) throws InterruptedException {
        supportDropDown.click();
        chatBotFunc.click();
        Thread.sleep(5000);
        chatBox.sendKeys(q1);
        chatBox.sendKeys(Keys.RETURN);
        Thread.sleep(10000);
        chatBox.sendKeys(q2);
        chatBox.sendKeys(Keys.RETURN);
        Thread.sleep(10000);
    }

    public void faq() {
        supportDropDown.click();
        driver.findElement(By.xpath("//ul[@class = 'dropdown-menu dropdown-visible']/li[1]/a")).click();
    }

    public void howToStart() {
        supportDropDown.click();
        driver.findElement(By.xpath("//ul[@class = 'dropdown-menu dropdown-visible']/li[2]/a")).click();
    }

    public void askQuestion() {
        supportDropDown.click();
        driver.findElement(By.xpath("//ul[@class = 'dropdown-menu dropdown-visible']/li[4]/a")).click();

    }

}
