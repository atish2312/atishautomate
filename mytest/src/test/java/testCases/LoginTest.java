    package testCases;

    import org.testng.Assert;
    import org.testng.annotations.Listeners;
    import org.testng.annotations.Test;
    import pageObjects.LoginPage;
    import testBase.BaseClass;

    import org.testng.annotations.Test;
    import pageObjects.LoginPage;
    import testBase.BaseClass;
    public class LoginTest extends BaseClass {

        @Test(priority = 2, groups = "smoke")
        public void loginTest() {
            LoginPage loginPage = new LoginPage(driver);

            wait.waitForElementClickable(loginPage.clickSignLoginButton()).click();
            Assert.fail();



        }
    }
