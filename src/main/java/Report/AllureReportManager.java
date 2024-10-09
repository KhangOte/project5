package Report;

import Test.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.TestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static Test.BaseTest.driver;
import static io.qameta.allure.model.Status.BROKEN;
import static io.qameta.allure.model.Status.FAILED;


public class AllureReportManager implements TestLifecycleListener {

    private static String getTestMethodName(TestResult result) {
        return result.getName();
    }

    @Attachment(value = "Page Screenshot", type = "image/png")
    public static byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    @Override
    public void beforeTestStop(TestResult result) {
        if (FAILED == result.getStatus() || BROKEN == result.getStatus()) {
            saveTextLog("beforeTestStop" + getTestMethodName(result) + " failed");
            if (BaseTest.driver != null) {
                saveScreenshotPNG(BaseTest.driver);
            }
        }
    }
}
