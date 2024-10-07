package Report;

import Test.BaseTest;
import com.aventstack.extentreports.Status;
import io.qameta.allure.Allure;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static Report.ExtentReportManager.captureScreenshot;
import static Report.ExtentReportManager.getScreenshotName;
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
        AllureReportManager.saveScreenshotPNG();
    }

    public void onTestSuccess(ITestResult result) {
//        String msgSuccess = result.getName() + " is successful";
//        String screenshotName = getScreenshotName(result.getName());
//        captureScreenshot(((BaseTest) result.getInstance()).driver, screenshotName);
//        testCaseReport.addScreenCaptureFromPath(screenshotName)
//                .log(Status.PASS, msgSuccess);
        AllureReportManager.saveTextLog(result.getName() + "is successful");
        AllureReportManager.saveScreenshotPNG();
    }

//    public void onFinish(ITestContext context) {
//        System.out.println("======== Finish test " + context. + " ========");
//
//    }
//    public void onStart(ITestContext context) {
//        System.out.println("======== Start " + context.getName() + " ========");
//    }
}
