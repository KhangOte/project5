package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserDropDown {
    WebDriver driver;
    public UserDropDown(WebDriver driver){
        this.driver = driver;
    }

    public void clickAPIKey(){
        driver.findElement(By.xpath("//ul[@id='user-dropdown-menu']//a[@href = '/api_keys']")).click();
    }
}
