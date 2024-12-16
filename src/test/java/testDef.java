import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class testDef extends TestBase{

    @Test
    public void testCase1() {
        open("https://www.google.com.vn/");
        $(By.name("q")).type("Hello");
        $(By.name("q")).setValue("World").shouldBe(visible);
    }
}
