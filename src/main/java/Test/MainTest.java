package Test;

import Page.*;
import Report.TestListener;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.swing.*;
import java.lang.reflect.Method;

import static Report.ExtentReportManager.*;

@Listeners(TestListener.class)
public class MainTest extends BaseTest {

    private String testName;

    @BeforeMethod
    public void testSetUp(Method testMethod) {
        super.testInit();
        testName = testMethod.getName();
        testCaseReport = reports.createTest(testName);
    }

    @Test
    @DataProvider(name = "testLogin")
    public static Object[][] accountForTestLogin() {
        return new Object[][]{{"minionmatbua@gmail", "123456"}, {"minionmatbua@gmail.com", "12345"}, {"minionmatbua@gmail.com", "12345678"}};
//        return new Object[][]{{"minionmatbua@gmail.com", "12345678"}};
    }

    @Test(dataProvider = "testLogin")
    public void testLogin(String email, String password) {
        TopMenu topMenu = new TopMenu(driver);
        LoginPage loginPage = topMenu.clickLoginButton();
        loginPage.login(email, password);
        String msgLoginSuccess = "Signed in successfully.";
        String resultLoginMsg = loginPage.verifyLogin();
//        String nameScreenShot = getScreenshotName(testName);
//        captureScreenshot(driver, nameScreenShot);
//        testCaseReport.addScreenCaptureFromPath(nameScreenShot).log(Status.INFO, "Capture screenshot after run testLogin");
        Assert.assertEquals(resultLoginMsg, msgLoginSuccess);
    }

    @Test
    public void testBlogPage() {
        TopMenu topMenu = new TopMenu(driver);
        BlogPage blogPage = topMenu.clickBlogButton();
        ChangeFocusTab changeFocusTab = new ChangeFocusTab(driver);
        changeFocusTab.switchTab(1);
        blogPage.clickAll();
        captureScreenShotAndAddToReport(driver, testName, Status.INFO, "Done");
        blogPage.clickWeather();
        captureScreenShotAndAddToReport(driver, testName, Status.INFO, "Done");
        blogPage.clickAgro();
        captureScreenShotAndAddToReport(driver, testName, Status.INFO, "Done");
        blogPage.clickTechnologies();
        captureScreenShotAndAddToReport(driver, testName, Status.INFO, "Done");
        blogPage.clickPlatform();
        captureScreenShotAndAddToReport(driver, testName, Status.INFO, "Done");
        blogPage.clickTeamCompany();
        captureScreenShotAndAddToReport(driver, testName, Status.INFO, "Done");
    }

    @Test
    @DataProvider(name = "testMarketplace")
    public static Object[][] idCoordinates() {
        return new Object[][]{{11, 24}, {45, 67}};
    }

    @Test(dataProvider = "testMarketplace")
    public void testMarketplace(int id1, int id2) throws InterruptedException {
        TopMenu topMenu = new TopMenu(driver);
        MarketplacePage marketplacePage = topMenu.clickMarketplaceButton();
        ChangeFocusTab changeFocusTab = new ChangeFocusTab(driver);
        changeFocusTab.switchTab(1);
        CreateNewHistory createNewHistory = new CreateNewHistory(driver);
//        marketplacePage.clickDocHistoryBulk();
//        changeFocusTab.switchTab(1);
        marketplacePage.clickPlaceOrderHistoryBulk();
        createNewHistory.searchByCoordinates(id1, id2);
        Thread.sleep(5000);
    }

    @Test
    @DataProvider(name = "testSupport")
    public static Object[][] questionChatBot() {
        return new Object[][]{{"What is openweather?", "how can i contact with you?"}, {"How to get info weather from page?", "How to create new account?"}};
    }

    @Test(dataProvider = "testSupport")
    public void testSupport(String q1, String q2) throws InterruptedException {
        SupportDropBox supportDropBox = new SupportDropBox(driver);
        ChangeFocusTab changeFocusTab = new ChangeFocusTab(driver);
        supportDropBox.askQuestion();
        changeFocusTab.switchTab(1);
        supportDropBox.faq();
        supportDropBox.howToStart();
        supportDropBox.chatBot(q1, q2);

    }

    @Test
    public void testOurInitiatives() {
        TopMenu topMenu = new TopMenu(driver);
        OurInitiativesPage ourInitiativesPage = topMenu.clickOurInitiatives();
        WebElement elementLoad = driver.findElement(By.xpath("//div[@class = 'section main-banner our-initiatives-banner']"));
        WebElement elementScroll = driver.findElement(By.xpath("//div[3]//a[@class = 'ow-btn round btn-orange']"));
        topMenu.waitDisplay(elementLoad);
        topMenu.scroll(elementScroll);
        captureScreenShotAndAddToReport(driver,testName,Status.INFO,"Done");
//        ourInitiativesPage.getAccessToStudentInitiative();

    }

    @AfterMethod
    public void extracted() {
        driver.quit();
        reports.flush();
    }
}
