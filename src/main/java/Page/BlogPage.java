package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Report.ExtentReportManager.captureScreenshot;
import static Report.ExtentReportManager.getScreenshotName;
import static Test.BaseTest.testCaseReport;

public class BlogPage {
    WebDriver driver;

    public BlogPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAll() {
        driver.findElement(By.linkText("ALL")).click();
    }

    public void clickWeather() {
        driver.findElement(By.linkText("WEATHER")).click();
    }

    public void clickAgro() {
        driver.findElement(By.linkText("AGRO")).click();
    }

    public void clickPlatform() {
        driver.findElement(By.linkText("PLATFORM")).click();
    }

    public void clickTechnologies() {
        driver.findElement(By.linkText("TECHNOLOGIES")).click();
    }

    public void clickEducation() {
        driver.findElement(By.linkText("EDUCATION")).click();
    }

    public void clickTeamCompany() {
        driver.findElement(By.linkText("TEAM&COMPANY")).click();
    }

}
