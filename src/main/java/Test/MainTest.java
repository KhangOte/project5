package Test;

import Page.*;
import Report.AllureReportManager;
import Report.TestListener;
import com.aventstack.extentreports.Status;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.lang.reflect.Method;

import static Report.ExtentReportManager.*;

@Listeners({TestListener.class})
public class MainTest extends BaseTest {

    private String testName;

    @BeforeMethod
    public void testSetUp(Method testMethod) {
        super.testInit();
        testName = testMethod.getName();
        System.out.println("======== Start " + testName + " ========");
        testCaseReport = reports.createTest(testName);

    }

    @Test
    @DataProvider(name = "testLogin")
    public static Object[][] accountForTestLogin() {
//        return new Object[][]{{"minionmatbua@gmail", "123456"}, {"minionmatbua@gmail.com", "12345678"}};
        return new Object[][]{{"minionmatbua@gmail.com", "1234567"}};
    }

    @Test(dataProvider = "testLogin")
    public void testLogin(String email, String password) {
        TopMenu topMenu = new TopMenu(driver);
        LoginPage loginPage = topMenu.clickLoginButton();
        loginPage.login(email, password);
        String msgLoginSuccess = "Signed in successfully1.";
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
        return new Object[][]{{45, 67}, {23, 27}};
    }

    @Test(dataProvider = "testMarketplace")
    public void testMarketplace(int id1, int id2) throws InterruptedException {

        String lat = "Latitude: ";
        String longt = "Longitude: ";
        String popUpMarkerLocator = "//div[@class = 'map-container']/div[1]/div[1]";

        TopMenu topMenu = new TopMenu(driver);
        MarketplacePage marketplacePage = topMenu.clickMarketplaceButton();
        ChangeFocusTab changeFocusTab = new ChangeFocusTab(driver);
        changeFocusTab.switchTab(1);
        CreateNewHistory createNewHistory = new CreateNewHistory(driver);
        marketplacePage.clickPlaceOrderHistoryBulk();
        createNewHistory.searchByCoordinates(id1, id2);

        WebElement latLonPopup = topMenu.waitForElementDisplay(driver, popUpMarkerLocator);

        String x = latLonPopup.findElement(By.tagName("p")).getText(); // => findElement "Longitude" in string "latLonPopup" after that get fist element
        System.out.println(x);
        System.out.println(getLatLon(x, lat));
        int id3 = Integer.parseInt(getLatLon(x, lat));
        Assert.assertEquals(id1, id3); // => check id display

        String y = latLonPopup.findElements(By.tagName("p")).get(1).getText();// => findElement "Longitude" in string "latLonPopup" after that get second element
        System.out.println(getLatLon(y, longt));
        int id4 = Integer.parseInt(getLatLon(y, longt));
        Assert.assertEquals(id2, id4); // => check id display

        captureScreenShotAndAddToReport(driver, testName, Status.INFO, "Import local display correctly");
        Thread.sleep(5000);
    }

    private String getLatLon(String x, String text) {
        return x.substring(text.length(), x.length());
    }

    @Test
    @DataProvider(name = "testSupport")
    public static Object[][] questionChatBot() {
        return new Object[][]{{"What is that?", "what is OpenWeather?"}};
    }

    @Test(dataProvider = "testSupport")
    public void testSupport(String q1, String q2) throws InterruptedException {
        String email = "minionmatbua@gmail.com";
        String pwd = "12345678";
        String nameFAQPage = "Frequently Asked Questions";

        TopMenu topMenu = new TopMenu(driver);
        SupportDropBox supportDropBox = new SupportDropBox(driver);
        LoginPage loginPage = topMenu.clickLoginButton();
        loginPage.login(email, pwd);
        supportDropBox.askQuestion();
        WebElement linkContainEmail = driver.findElement(By.xpath("//div//input[@class = 'form-control string email required disabled' and @name = 'question_form[email]']"));
        String getEmail = linkContainEmail.getAttribute("value");
        System.out.println("email: " + getEmail);
        Assert.assertEquals(getEmail, email); // => check using email for AskQuestion page correct with user email

        supportDropBox.faq();
        Assert.assertEquals(driver.findElement(By.xpath("//div//h1[@class = 'breadcrumb-title']")).getText(), nameFAQPage);// => confirm name page FQA
        supportDropBox.chatBot(q1, q2, testName);
        String answerFail = "I only provide documentation support.";
        String getAnswer = driver.findElement(By.xpath("//div[@class = 'flex flex-col h-full grow rounded-xl border bg-white shadow-lg']/div[2]/div/div[3]/div[1]")).getText();
        Assert.assertEquals(getAnswer, answerFail); // => check answer of chatbot when question is wrong
    }

    @Test
    public void testOurInitiatives() {

        String textCompere = "Free Data for Students1";
        String elementLoad = "//div[@class = 'section main-banner our-initiatives-banner']";

        TopMenu topMenu = new TopMenu(driver);
        OurInitiativesPage ourInitiativesPage = topMenu.clickOurInitiatives();
        WebElement elementScroll = driver.findElement(By.xpath("//div[3]//a[@class = 'ow-btn round btn-orange']"));
        topMenu.waitForElementDisplay(driver, elementLoad);
        topMenu.scroll(elementScroll);
        captureScreenShotAndAddToReport(driver, testName, Status.INFO, "Done");
        ourInitiativesPage.getAccessToStudentInitiative();
        topMenu.switchTab(1);
        String getTextToCompere = driver.findElement(By.xpath("//div//h1[@class = 'orange-text']")).getText();
        Assert.assertEquals(getTextToCompere, textCompere); // => check if the correct page loaded
    }

    @DataProvider(name = "testSearchFunc")
    public static Object[][] localToTestSearchFunc(){
        return new Object[][]{{"ho chi minh"},{"ha noi"}};
    }

    @Story("Empty username and password login test")
    @Test(dataProvider = "testSearchFunc")
    @Description("Test Description: Login test with empty username and empty password.")
    public void testSearchFunc(String keySearch) {
        String redundantText = ", VN";
        String searchBoxLocator = "//li[@id = 'desktop-menu']/form/input[1]";
        String resultSearchLocator = "//table[@class = 'table']/tbody/tr[1]/td[2]/b[1]/a";
//        Allure.step("click menu");
        AllureReportManager.saveTextLog("allure log");

        TopMenu topMenu = new TopMenu(driver);

        WebElement searchBox = driver.findElement(By.xpath("//li[@id = 'desktop-menu']/form/input[1]"));
        topMenu.waitForElementDisplay(driver, searchBoxLocator);
        searchBox.sendKeys(keySearch);
        searchBox.sendKeys(Keys.RETURN);

        WebElement resultSearch = topMenu.waitForElementDisplay(driver, resultSearchLocator);
        AllureReportManager.saveScreenshotPNG(driver);
        String textSearchResult = resultSearch.getText();


        String textToCheck = getTextToCheck(textSearchResult, redundantText).toLowerCase();
        System.out.println(textToCheck);
        Assert.assertEquals(keySearch, textToCheck);

    }

    private String getTextToCheck(String text1, String text2) {
        int eleToCompere = text1.length() - text2.length();
        return text1.substring(0, eleToCompere);
    }


    @AfterMethod
    public void tearDown() {
        System.out.println("======== Finish test " + testName + " ========");
        driver.quit();
        reports.flush();

    }
}
