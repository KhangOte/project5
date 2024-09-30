package Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.SimpleTimeZone;

import static Test.BaseTest.testCaseReport;

public class ExtentReportManager {

    static String reportFolder = ".\\Report\\";

    public static ExtentReports generaTestReport() {
        ExtentReports extentReporter = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(reportFolder);
        extentReporter.attachReporter(spark);
        return extentReporter;
    }

    public static void captureScreenshot(WebDriver driver, String filename) {
        File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshotFile = new File(reportFolder + filename);
        try {
            FileUtils.copyFile(image, screenshotFile);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void captureScreenShotAndAddToReport(WebDriver driver, String filename, Status status,String reportMsg ){
        String createName = getScreenshotName(filename);
        captureScreenshot(driver, filename);
        System.out.println("capture screenshot");
        testCaseReport.addScreenCaptureFromPath(createName).log(Status.INFO, reportMsg);
        System.out.println("add Picture");
    }

    public static String getCurrentTime() {
        String currentTime = new SimpleDateFormat("yyyyMMdd-HHmmss").
                format(Calendar.getInstance().getTime()) + ".png";
        return currentTime;
    }

    public static String getScreenshotName(String testName) {
        String nameScreenshot = testName + "_" + ExtentReportManager.getCurrentTime();
        return nameScreenshot;
    }
}
