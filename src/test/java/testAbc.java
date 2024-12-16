import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pom.vietjet.HomePage;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.*;

public class testAbc extends TestBase{
    HomePage homePage  =new HomePage();

    @Test
    public void testCase1() {
        homePage.openGooglePage();
        homePage.enterText();
        $(By.name("q")).setValue("World").shouldHave(exactText("Some text"));
    }
}
