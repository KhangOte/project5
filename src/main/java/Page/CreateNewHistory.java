package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewHistory {
    WebDriver driver;
    @FindBy(xpath = "//div//input[@id = 'firstSearch' and @class = 'pac-target-input']")
    WebElement searchBox;

    @FindBy(xpath = "//div//input[@placeholder = 'Latitude' and @class = 'coordinates']")
    WebElement latitude;

    @FindBy(xpath = "//div//input[@placeholder = 'Longitude' and @class = 'coordinates']")
    WebElement longitude;

    public CreateNewHistory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchByLocation(String local) {
        searchBox.click();
        driver.findElement(By.xpath("//div//button [@class = 'padded-button padded-button-active']")).click();
        searchBox.sendKeys(local);
    }

    public void searchByCoordinates(int id1, int id2) {
        searchBox.click();
        driver.findElement(By.xpath("//div[2]/div/div[1]/div[1]/div[1]/div[3]/button[2]")).click();
        latitude.sendKeys(String.valueOf(id1));
        longitude.sendKeys(String.valueOf(id2));
        longitude.sendKeys(Keys.RETURN);
    }

}
