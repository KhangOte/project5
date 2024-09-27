package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopMenu {
    WebDriver driver;

    public TopMenu(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickLoginButton() {
        driver.findElement(By.linkText("Sign in")).click();
        return new LoginPage(driver);
    }

    public BlogPage clickBlogPage(){
        driver.findElement(By.linkText("Blog")).click();
        return new BlogPage(driver);
    }

}
