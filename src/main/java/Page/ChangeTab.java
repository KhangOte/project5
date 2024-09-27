package Page;

import Test.BaseTest;
import org.openqa.selenium.WebDriver;

public class ChangeTab {
    WebDriver driver;
    public ChangeTab(WebDriver driver){
        this.driver = driver;
    }

    public void switchTab(int numberTab){
        Object[] windowHandle = driver.getWindowHandles().toArray();
        driver.switchTo().window(windowHandle[numberTab].toString());
    }
}
