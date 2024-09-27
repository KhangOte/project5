package Test;

import Page.BlogPage;
import Page.ChangeTab;
import Page.LoginPage;
import Page.TopMenu;
import Report.ExtentReportManager;
import Report.TestListener;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.*;

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
    public void testBlogPage() throws InterruptedException {
        TopMenu topMenu = new TopMenu(driver);
        BlogPage blogPage = topMenu.clickBlogPage();
        ChangeTab changeTab = new ChangeTab(driver);
        changeTab.switchTab(1);
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


    @AfterMethod
    public void extracted() {
        driver.quit();
        reports.flush();
    }
}
