package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ISuiteListener;
import org.testng.ISuite;

public class TestListener implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        ReportManager.initReport();
    }

    @Override
    public void onFinish(ISuite suite) {
        ReportManager.flushReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ReportManager.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ReportManager.logPass("Test passed: " +
            result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ReportManager.logFail("Test failed: " +
            result.getThrowable().getMessage());
    }

    @Override
    public void onStart(org.testng.ITestContext context) {}

    @Override
    public void onFinish(org.testng.ITestContext context) {}
}