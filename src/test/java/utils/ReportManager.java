package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {

    private static ExtentReports extent;
    private static ExtentTest test;

    public static void initReport() {
        ExtentSparkReporter spark = new ExtentSparkReporter(
            "reports/TestReport.html"
        );
        spark.config().setReportName("E-Commerce Automation Report");
        spark.config().setDocumentTitle("Test Results");
        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Tester", "Aumkar");
        extent.setSystemInfo("Environment", "SauceDemo");
        extent.setSystemInfo("Browser", "Chrome");
    }

    public static void createTest(String testName) {
        test = extent.createTest(testName);
    }

    public static void logPass(String message) {
        test.pass(message);
    }

    public static void logFail(String message) {
        test.fail(message);
    }

    public static void flushReport() {
        extent.flush();
    }
}