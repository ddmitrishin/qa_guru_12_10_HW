package dmitrishin.pages;

import com.codeborne.selenide.SelenideElement;
import dmitrishin.data.GenerateData;
import dmitrishin.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {
    CalendarComponent calendar = new CalendarComponent();
    GenerateData generateData = new GenerateData();
    public String headerText = "Student Registration Form";

    //locators
    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement emailInput = $("#userEmail");
    SelenideElement genderRadioButton = $("#genterWrapper");
    SelenideElement userPhoneNumberInput = $("#userNumber");
    SelenideElement subjectInput = $("#subjectsInput");
    SelenideElement hobbiesCheckBox = $("#hobbiesWrapper");
    SelenideElement dateName = $("#dateOfBirthInput");
    SelenideElement filePathInput = $("#uploadPicture");
    SelenideElement addressInput = $("#currentAddress");
    SelenideElement stateButton = $("#state");
    SelenideElement cityButton = $("#city");
    SelenideElement stateAndCitySelect = $("#stateCity-wrapper");
    SelenideElement submitButton = $("#submit");
    SelenideElement tableTitle = $("#example-modal-sizes-title-lg");
    SelenideElement resultTable = $(".table-responsive");
    //actions

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(headerText));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationFormPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationFormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationFormPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public RegistrationFormPage setGender(String genderType) {
        genderRadioButton.$(byText(genderType)).click();
        return this;
    }

    public RegistrationFormPage setPhoneNumber(String phoneNumber) {
        userPhoneNumberInput.setValue(phoneNumber);
        return this;
    }

    public RegistrationFormPage setDate(String day, String month, String year) {
        dateName.click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationFormPage setSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationFormPage setHobbies(String hobby) {
        hobbiesCheckBox.$(byText(hobby)).click();
        return this;
    }

    public RegistrationFormPage setPath(String path) {
        filePathInput.uploadFromClasspath(path);
        return this;
    }

    public RegistrationFormPage setAddress(String address) {
        addressInput.setValue(address);
        return this;
    }

    public RegistrationFormPage setState(String state) {
        stateButton.click();
        stateAndCitySelect.$(byText(state)).click();
        return this;
    }

    public RegistrationFormPage setCity(String city) {
        cityButton.click();
        stateAndCitySelect.$(byText(city)).click();
        return this;
    }

    public void pressSubmit() {
        submitButton.click();
    }

    public RegistrationFormPage checkResultTitle(String value) {
        tableTitle.shouldHave(text(value));
        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        resultTable.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

}
