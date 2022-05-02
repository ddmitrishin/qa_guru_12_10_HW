package dmitrishin.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class PracticeFormTests extends TestBase {

    @Test
    @DisplayName("Successful fill registration form")
    void fillPracticeFormTest() {

        step("Open registration form", () -> {
            registrationFormPage.openPage();
        });

        step("Fill registration form", () -> {
            registrationFormPage.setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(email)
                    .setGender(gender)
                    .setPhoneNumber(phone)
                    .setDate(dayOfBirth, monthOfBirth, yearOfBirth)
                    .setSubject(subject)
                    .setHobbies(hobby)
                    .setPath(imagePath)
                    .setAddress(address)
                    .setState(state)
                    .setCity(city)
                    .pressSubmit();
        });

        step("Verify results", () -> {
            registrationFormPage.checkResultTitle(resultTitle)
                    .checkResult("Student Name", fullName)
                    .checkResult("Student Email", email)
                    .checkResult("Gender", gender)
                    .checkResult("Mobile", phone)
                    .checkResult("Date of Birth", dateOfBirth)
                    .checkResult("Subjects", subject)
                    .checkResult("Hobbies", hobby)
                    .checkResult("Picture", fileName)
                    .checkResult("Address", address)
                    .checkResult("State and City", stateAndCity);
        });
    }
}
