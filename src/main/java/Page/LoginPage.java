package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(xpath = "//input[@class = 'string email optional form-control' and @name = 'user[email]']")
    WebElement userEmailBox;

    @FindBy(xpath = "//input[@class = 'form-control' and @name = 'user[password]']")
    WebElement userPasswordBox;

    @FindBy(xpath = "//input[@type = 'submit' and @name = 'commit' and @value = 'Submit']")
    WebElement summitButton;


    public  LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void login(String email, String password) {
        userEmailBox.sendKeys(email);
        userPasswordBox.sendKeys(password);
        summitButton.click();
    }

    public String verifyLogin(){
        String getMsgResultLogin = driver.findElement(By.xpath("//div[@class = 'panel-body']")).getText();
        return getMsgResultLogin;
    }
}
