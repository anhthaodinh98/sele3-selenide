import com.codeborne.selenide.Configuration;
import org.testng.annotations.*;

public class TestBase {
    @Parameters({"browser", "headless"})
    @BeforeClass(alwaysRun = true)
    public void config(String browser, @Optional Boolean headless) {
        Configuration.browser = browser;
        Configuration.headless = headless == null ? Configuration.headless : headless;
    }
}
