package com.snackattack.stepdefs.e2e_stepdefs;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.snackattack.pages.RegisterPage;
import com.snackattack.utilities.Driver;
import com.snackattack.utilities.ReusableMethods;
import com.snackattack.utilities.TestData;
import java.time.Duration;
import static org.junit.Assert.*;
public class UI_UserRegisterStepDefs {

    RegisterPage registerPage = new RegisterPage();

    Faker faker = new Faker();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(TestData.EXPLICIT_WAIT));

    @Given("the user navigates to Speedyli homepage")
    public void the_user_navigates_to_speedyli_homepage() {
        Driver.getDriver().get(TestData.SPEEDYLI_URL);
    }

    @When("the user verifies the URL is correct")
    public void the_user_verifies_the_url_is_correct() {
        String actualUrl = Driver.getDriver().getCurrentUrl();
        assertEquals("URL doğrulama başarısız", TestData.SPEEDYLI_URL, actualUrl);
    }

    @And("the user clicks on Register button")
    public void the_user_clicks_on_register_button() {
        registerPage.registerButton.click();
    }

    @And("the user clicks on Register form button")
    public void the_user_clicks_on_register_form_button() {
        registerPage.registerFormButton.click();
    }

    @And("the user enters first name {string}")
    public void the_user_enters_first_name(String firstName) {
        String name = firstName.equals("random") ? faker.name().firstName() : firstName;
        registerPage.firstNameTextBox.sendKeys(name);
        TestData.expectedFirstName = name;
    }

    @And("the user enters last name {string}")
    public void the_user_enters_last_name(String lastName) {
        String name = lastName.equals("random") ? faker.name().lastName() : lastName;
        registerPage.lastNameTextBox.sendKeys(name);
        TestData.expectedLastName = name;
    }

    @And("the user enters phone number {string}")
    public void the_user_enters_phone_number(String phoneNumber) {
        registerPage.phoneNumberTextBox.click();
        registerPage.phoneNumberTextBox.sendKeys(phoneNumber);
        TestData.expectedPhoneNumber = phoneNumber;
    }

    @And("the user enters address {string}")
    public void the_user_enters_address(String address) {
        String addr = address.equals("random") ? faker.address().fullAddress() : address;
        registerPage.addressTextBox.sendKeys(addr);
        TestData.expectedAddress = addr;
    }

    @And("the user enters zip code {string}")
    public void the_user_enters_zip_code(String zipCode) {
        String zip = zipCode.equals("random") ? faker.address().zipCode() : zipCode;
        registerPage.zipCodeTextBox.sendKeys(zip);
        TestData.expectedZipCode = zip;
    }

    @And("the user enters email {string}")
    public void the_user_enters_email(String email) {
        String emailAddress = email.equals("random") ? faker.internet().emailAddress() : email;
        registerPage.emailTextBox.sendKeys(emailAddress);
        TestData.expectedEmail = emailAddress;
        System.out.println("emailAddress = " + emailAddress);
    }

    @And("the user enters password {string}")
    public void the_user_enters_password(String password) {
        registerPage.passwordTextBox.sendKeys(password);
    }

    @And("the user enters confirm password {string}")
    public void the_user_enters_confirm_password(String confirmPassword) {
        registerPage.confirmPasswordTextBox.sendKeys(confirmPassword);
    }

    @And("the user scrolls down the page")
    public void the_user_scrolls_down_the_page() {
        ReusableMethods.waitForSecond(TestData.SCROLL_WAIT);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitForSecond(TestData.SCROLL_WAIT);
    }

    @And("the user clicks Submit button")
    public void the_user_clicks_submit_button() {
        registerPage.submitButton.click();
    }

    @Then("the user should see success message {string}")
    public void the_user_should_see_success_message(String expectedMessage) {
        // Explicit wait ile success mesajının görünür olmasını bekle
        wait.until(ExpectedConditions.visibilityOf(registerPage.successMessage));
        // Mesajın içeriğini doğrula
        String actualMessage = registerPage.successMessage.getText();
        assertTrue("Başarı mesajı doğrulama başarısız. Beklenen: " + expectedMessage +
                ", Bulunan: " + actualMessage, actualMessage.contains(expectedMessage));
    }


    @And("the user close the page")
    public void theUserCloseThePage() {
        Driver.closeDriver();
    }
}
