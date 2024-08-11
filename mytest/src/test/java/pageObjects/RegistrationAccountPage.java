package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationAccountPage {
    private final WebDriver driver;
    By click_sign_login = By.xpath("//a[normalize-space()='Signup / Login']");
    By name_text_field = By.xpath("//input[@placeholder='Name']");
    By email_text_field = By.xpath("//input[@data-qa='signup-email']");
    By click_sig_btn = By.xpath("//button[normalize-space()='Signup']");
    By mr_mrs = By.xpath("//input[@id='id_gender1']");
    By password_text_field = By.xpath("//input[@type='password']");
    By select_birth_day = By.xpath("//select[@id='days']");

    public RegistrationAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement clickSignLoginButton()  {
        return driver.findElement(click_sign_login);
    }

    public WebElement nameTextField() {
        return driver.findElement(name_text_field);
    }

    public WebElement emailTextField() {
        return driver.findElement(email_text_field);
    }

    public WebElement clickSignButton() {
        return driver.findElement(click_sig_btn);
    }

    public WebElement radioMrMrs() {
        return driver.findElement(mr_mrs);
    }

    public WebElement passwordTextField() {
        return driver.findElement(password_text_field);
    }

    public WebElement birthDay() {
        return driver.findElement(select_birth_day);
    }
}
