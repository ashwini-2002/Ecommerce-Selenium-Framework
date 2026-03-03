package listeners;

import org.testng.*;
import utils.ScreenshotUtil;
import com.aventstack.extentreports.*;
import utils.ExtentManager;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getReportInstance();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        try {
            String path = ScreenshotUtil.capture(
                base.DriverManager.getDriver(),
                result.getName());

            test.addScreenCaptureFromPath(path);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}