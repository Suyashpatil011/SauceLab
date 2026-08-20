package Listener;

import Base.Base;
import Utils.ExtentManager;
import Utils.ScreenshotUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static final ExtentReports extent = ExtentManager.getInstance();
    private static final ThreadLocal<ExtentTest> currentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        currentTest.set(extent.createTest(result.getMethod().getMethodName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTest test = currentTest.get().log(Status.PASS, "Test passed");
        String screenshotPath = ScreenshotUtils.capture(Base.getDriver(), result.getMethod().getMethodName());
        if (screenshotPath != null) {
            try {
                test.addScreenCaptureFromPath(screenshotPath);
            } catch (Exception e) {
                test.log(Status.WARNING, "Could not attach screenshot: " + e.getMessage());
            }
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        currentTest.get().log(Status.FAIL, result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        currentTest.get().log(Status.SKIP, result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
