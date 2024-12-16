package pom.vietjet;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.Date;

import static com.codeborne.selenide.Selenide.*;

public class HomePage {
    private String returnRadioButton = "(//input[@value='roundTrip'])[1]";
    private String oneWayRadioButton = "(//input[@value='oneway'])[1]";
    private String fromTextBox = "(//label[text()='From' or text()='Điểm khởi hành']/following-sibling::div/input)[1]";
    private String toTextBox = "(//label[text()='To' or text()='Điểm đến']/following-sibling::div/input)[1]";
    private String passengerDropdown = "//label[text()='Passenger' or text()='Hành khách']/following-sibling::div/input";
    private String searchTicketButton = "//button/span[text()=\"Let's go\" or text()='Tìm chuyến bay']";
    private String cityCode = "//div[@translate='no' and text()='%s']";
    private String minusAdultsButton = "//div[p[contains(text(), '12')]]/parent::div/following-sibling::div/button[1]";
    private String plusAdultsButton = "//div[p[contains(text(), '12')]]/parent::div/following-sibling::div/button[2]";
    private String minusChildrenButton = "//div[p[contains(text(), '2-11')]]/parent::div/following-sibling::div/button[1]";
    private String plusChildrenButton = "//div[p[contains(text(), '2-11')]]/parent::div/following-sibling::div/button[2]";
    private String minusInfantsButton = "//div[p[contains(text(), ' 2 ')]]/parent::div/following-sibling::div/button[1]";
    private String plusInfantsButton = "//div[p[contains(text(), ' 2 ')]]/parent::div/following-sibling::div/button[2]";
    private String adultsAmount = minusAdultsButton + "/following-sibling::span";
    private String childrenAmount = minusChildrenButton + "/following-sibling::span";
    private String infantsAmount = minusInfantsButton + "/following-sibling::span";
    private String departureDatePicker = "(//p[text()='Departure date' or text()='Ngày đi'])[1]";
    private String returnDatePicker = "(//p[text()='Return Date' or text()='Ngày về'])[1]";

    @Step("Navigate to Google page")
    public void openGooglePage() {
        open("https://www.google.com.vn/");
    }

    @Step("Type ...")
    public void enterText() {
        $(By.name("q")).type("Hello");
    }

    public void selectReturnFlight() {
        $x(returnRadioButton).click();
    }

    public void selectOneWayFlight() {
        $x(oneWayRadioButton).click();
    }

    public void selectFromPlace(String city) {
        $x(fromTextBox).setValue(city);
        $x(String.format(cityCode, city)).click();
    }

    public void selectToPlace(String city) {
        $x(toTextBox).setValue(city);
        $x(String.format(cityCode, city)).click();
    }

    public void selectPassenger(int adults, int children, int infants) {
        $x(passengerDropdown).click();
        int missingAdults = getMissingAmount(adultsAmount, adults);
        clickMissingAmount(minusAdultsButton, plusAdultsButton, missingAdults);
        int missingChildren = getMissingAmount(childrenAmount, children);
        clickMissingAmount(minusChildrenButton, plusChildrenButton, missingChildren);
        int missingInfants = getMissingAmount(infantsAmount, infants);
        clickMissingAmount(minusInfantsButton, plusInfantsButton, missingInfants);
    }

    public void selectDepartureDate(Date date) {
        $x(departureDatePicker).click();
        selectDate(date);
    }

    public void selectReturnDate(Date date) {
        $x(returnDatePicker).click();
        selectDate(date);
    }

    private int getMissingAmount(String passengerTypeXpath, int amount){
        int currentAmount = Integer.parseInt($x(passengerTypeXpath).getText());
        return amount - currentAmount;
    }

    /**
     *
     * @param buttonMinusXpath
     * @param buttonPlusXpath
     * @param amount
     */
    private void clickMissingAmount(String buttonMinusXpath, String buttonPlusXpath, int amount) {
        if (amount > 0) {
            for (int i = 0; i < amount; i++) {
                $x(buttonPlusXpath).click();
            }
        } else if (amount < 0) {
            for (int i = 0; i < amount * (-1); i++) {
                $x(buttonMinusXpath).click();
            }
        }
//        Selenide.sleep(500);

    }

    private void selectDate(Date date) {

    }












}
