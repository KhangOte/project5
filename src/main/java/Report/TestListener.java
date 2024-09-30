package Report;

import Test.BaseTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static Report.ExtentReportManager.captureScreenshot;
import static Report.ExtentReportManager.getScreenshotName;
import static Test.BaseTest.testCaseReport;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        String screenshotName = getScreenshotName(result.getName());
        captureScreenshot(((BaseTest) result.getInstance()).driver, screenshotName);
        testCaseReport.addScreenCaptureFromPath(screenshotName)
                .log(Status.FAIL, "Test failed");
    }

    public void onTestSuccess(ITestResult result) {
        String screenshotName = getScreenshotName(result.getName());
        captureScreenshot(((BaseTest) result.getInstance()).driver, screenshotName);
        testCaseReport.addScreenCaptureFromPath(screenshotName)
                .log(Status.PASS, "Test successfully");
    }

    public void onFinish(ITestContext context) {
        System.out.println("======== Finish test========");

    }
}
