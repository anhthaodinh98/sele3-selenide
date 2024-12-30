package projects.vietjet;

import base.TestBase;
import org.testng.annotations.Test;
import pages.vietjet.HomePage;
import utils.I18nHelper;

import java.util.Locale;

public class TC001 extends TestBase {
    HomePage homePage  =new HomePage();

    @Test
    public void tc001() {
        I18nHelper.setLocale(new Locale("en"));

        homePage.openHomePage();


    }
}
