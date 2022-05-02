package dmitrishin.tests;

import com.codeborne.selenide.Configuration;
import dmitrishin.data.GenerateData;
import dmitrishin.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;

public class PracticeFormTests {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    GenerateData generate = new GenerateData();

    //Input parameters
    String firstName = generate.firstname;
    String lastName = generate.lastname;
    String email = generate.email;
    String gender = generate.setRandomGenderType();
    String phone = generate.phoneNumber;
    String dayOfBirth = generate.dayOfBirth;
    String monthOfBirth = generate.monthOfBirth;
    String yearOfBirth = generate.yearOfBirth;
    String subject = generate.setRandomSubject();
    String hobby = generate.setRandomHobbies();
    String imagePath = "img/Avatar.jpg";
    String address = generate.address;
    String state = "NCR";
    String city = "Delhi";
    String resultTitle = "Thanks for submitting the form";

    String fullName = format("%s %s", firstName, lastName);
    String dateOfBirth = format("%s %s,%s", dayOfBirth, monthOfBirth, yearOfBirth);
    String fileName = imagePath.substring(4);
    String stateAndCity = format("%s %s", state, city);


    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillPracticeFormTest() {

        //Fill Form
        registrationFormPage.openPage()
                .setFirstName(firstName)
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

        //Check results
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

    }
}
