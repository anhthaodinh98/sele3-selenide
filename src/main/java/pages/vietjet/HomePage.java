package pages.vietjet;

import io.qameta.allure.Step;
import utils.I18nHelper;

import java.util.Date;

import static com.codeborne.selenide.Selenide.*;
import static pages.vietjet.Constant.URL_HOME;

public class HomePage {
    private String returnRadioButton = "(//input[@value='roundTrip'])[1]";
    private String oneWayRadioButton = "(//input[@value='oneway'])[1]";
    private String fromTextBox = String.format("(//label[text()='%s']/following-sibling::div/input)[1]", I18nHelper.getString("from"));
    private String toTextBox = String.format("(//label[text()='%s']/following-sibling::div/input)[1]", I18nHelper.getString("to"));
    private String passengerDropdown = String.format("//label[text()='%s']/following-sibling::div/input", I18nHelper.getString("passenger"));
    private String searchTicketButton = String.format("//button/span[text()='%s']", I18nHelper.getString("findTicket"));
    private String cityCode = "//div[@translate='no' and text()='%s']";
    private String minusAdultsButton = String.format("//div[p[text()='%s']]/parent::div/following-sibling::div/button[1]", I18nHelper.getString("adults"));
    private String plusAdultsButton = String.format("//div[p[text()='%s']]/parent::div/following-sibling::div/button[2]", I18nHelper.getString("adults"));
    private String minusChildrenButton = String.format("//div[p[text()='%s']]/parent::div/following-sibling::div/button[1]", I18nHelper.getString("childrens"));
    private String plusChildrenButton = String.format("//div[p[text()='%s']]/parent::div/following-sibling::div/button[2]", I18nHelper.getString("childrens"));
    private String minusInfantsButton = String.format("//div[p[text()='%s']]/parent::div/following-sibling::div/button[1]", I18nHelper.getString("infants"));
    private String plusInfantsButton = String.format("//div[p[text()='%s']]/parent::div/following-sibling::div/button[2]", I18nHelper.getString("infants"));
    private String adultsAmount = minusAdultsButton + "/following-sibling::span";
    private String childrenAmount = minusChildrenButton + "/following-sibling::span";
    private String infantsAmount = minusInfantsButton + "/following-sibling::span";
    private String departureDatePicker = String.format("(//p[text()='%s'])[1]", I18nHelper.getString("departureDate"));
    private String returnDatePicker = String.format("(//p[text()='%s'])[1]", I18nHelper.getString("returnDate"));

    @Step("Navigate to VietJet home page")
    public void openHomePage() {
        open(String.format(URL_HOME + "%s", I18nHelper.getLocale()));
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
