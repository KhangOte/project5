package Report;

import Test.BaseTest;
import com.aventstack.extentreports.Status;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.InputStream;

import static Report.ExtentReportManager.captureScreenshot;
import static Report.ExtentReportManager.getScreenshotName;
import static Test.BaseTest.driver;
import static Test.BaseTest.testCaseReport;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
//        String msgFail = result.getName() + " is failed";
//        String screenshotName = getScreenshotName(result.getName());
//        captureScreenshot(((BaseTest) result.getInstance()).driver, screenshotName);
//        testCaseReport.addScreenCaptureFromPath(screenshotName)
//                .log(Status.FAIL,  msgFail);

        AllureReportManager.saveTextLog(result.getName() + "is failed");
        File sc = AllureReportManager.saveScreenshotPNG(((BaseTest) result.getInstance()).driver);
        try {
            Allure.addAttachment("Page screenshot", FileUtils.openInputStream(sc));
        } catch (Exception ex) {
            
        }
//        Allure.addAttachment("Search results" );
    }

    public void onTestSuccess(ITestResult result) {
//        String msgSuccess = result.getName() + " is successful";
//        String screenshotName = getScreenshotName(result.getName());
//        captureScreenshot(((BaseTest) result.getInstance()).driver, screenshotName);
//        testCaseReport.addScreenCaptureFromPath(screenshotName)
//                .log(Status.PASS, msgSuccess);
        AllureReportManager.saveTextLog(result.getName() + "is successful");
        AllureReportManager.saveScreenshotPNG(driver);
    }

//    public void onFinish(ITestContext context) {
//        System.out.println("======== Finish test " + context. + " ========");
//
//    }
//    public void onStart(ITestContext context) {
//        System.out.println("======== Start " + context.getName() + " ========");
//    }
}
