package com.snackattack.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.snackattack.utilities.Driver;

public class RegisterPage {
    public RegisterPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    // Ana sayfa register butonu
    @FindBy(xpath = "//a[@href='/auth']")
    public WebElement registerButton;
    // Register form açma butonu
    @FindBy(xpath = "//button[.='Register']")
    public WebElement registerFormButton;
    // Form alanları
    @FindBy(css = "input[name='firstName']")
    public WebElement firstNameTextBox;
    @FindBy(css = "input[name='lastName']")
    public WebElement lastNameTextBox;
    @FindBy(css = "input[name='phoneNumber']")
    public WebElement phoneNumberTextBox;
    @FindBy(css = "input[name='address']")
    public WebElement addressTextBox;
    @FindBy(css = "input[name='zipCode']")
    public WebElement zipCodeTextBox;
    @FindBy(xpath = "(//input[@name='email'])[2]")
    public WebElement emailTextBox;
    @FindBy(xpath = "(//input[@name='password'])[2]")
    public WebElement passwordTextBox;
    @FindBy(css = "input[name='confirmPassword']")
    public WebElement confirmPasswordTextBox;
    // Submit butonu
    @FindBy(xpath = "(//button[@type='submit'])[2]")
    public WebElement submitButton;
    // Başarı mesajı
    @FindBy(xpath = "//div[contains(text(), 'You are registered successfully')]")
    public WebElement successMessage;
}
