package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OurInitiativesPage {
    WebDriver driver;

    public OurInitiativesPage(WebDriver driver){
        this.driver = driver;
    }

    public void getAccessToStudentInitiative(){
        driver.findElement(By.xpath("//div[3]//a[@class = 'ow-btn round btn-orange']")).click();
    }
}
