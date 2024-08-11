package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private final WebDriver driver;
    By click_sign_login = By.xpath("//a[normalize-space()='Signup / Login']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement clickSignLoginButton() {
        return driver.findElement(click_sign_login);

    }
}
