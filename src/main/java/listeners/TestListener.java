package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import report.AllureManager;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        //Allure Report
//        AllureManager.saveTextLog(result.getName() + " is failed.");
        AllureManager.saveScreenshotPNG();
    }
}
