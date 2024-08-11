package Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import testBase.BaseClass;
import utilities.TakesScreenshots;

public class ExtentTestListener implements ITestListener {
    private static ExtentReports reports;
    private ExtentTest test;
    private WebDriver driver;
    private TakesScreenshots takesScreenshots;

    static {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extent-report.html");
        reports = new ExtentReports();
        reports.attachReporter(sparkReporter);
        sparkReporter.config().setReportName("Automation Test Report");
        sparkReporter.config().setDocumentTitle("Test Execution Report");
        sparkReporter.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.STANDARD); // or Theme.DARK for a dark theme
        reports.setSystemInfo("OS", "Windows 10");
        reports.setSystemInfo("Browser", "Chrome");
        reports.setSystemInfo("Automation Tester", "Atish");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Starting Test Suite: " + context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = reports.createTest(result.getMethod().getMethodName());
        driver = ((BaseClass) result.getInstance()).driver;
        takesScreenshots = new TakesScreenshots(driver, "screenshotsPath");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
        String screenshotFileName = result.getMethod().getMethodName() + ".png";
        String screenshotPath = takesScreenshots.captureScreenshot(screenshotFileName);
        test.addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        reports.flush();
    }
}
