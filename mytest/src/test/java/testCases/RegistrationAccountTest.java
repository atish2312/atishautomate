package testCases;


import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.RegistrationAccountPage;
import testBase.BaseClass;


public class RegistrationAccountTest extends BaseClass {

    @Test(priority = 1, groups = {"sanity"})
    public void testSignUp() throws InterruptedException {
        RegistrationAccountPage registrationAccountPage = new RegistrationAccountPage(driver);
        wait.waitForElementClickable(registrationAccountPage.clickSignLoginButton()).click();
        registrationAccountPage.nameTextField().sendKeys(randomCredentials.getRandomNumber());
        registrationAccountPage.emailTextField().sendKeys(randomCredentials.getRandomString() + "@gmail.com");
        System.out.println(registrationAccountPage.emailTextField().getAttribute("value"));
        registrationAccountPage.clickSignButton().click();
        registrationAccountPage.radioMrMrs().click();
        registrationAccountPage.passwordTextField().sendKeys("Atish");
        Select s = new Select(registrationAccountPage.birthDay());
        s.selectByValue("14");


    }
}
