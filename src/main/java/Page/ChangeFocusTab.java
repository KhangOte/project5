package Page;

import org.openqa.selenium.WebDriver;

public class ChangeFocusTab {
    WebDriver driver;
    public ChangeFocusTab(WebDriver driver){
        this.driver = driver;
    }

    public void switchTab(int numberTab){
        Object[] windowHandle = driver.getWindowHandles().toArray();
        driver.switchTo().window(windowHandle[numberTab].toString());
    }
}
