package testBase;

import Listeners.ExtentTestListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigReader;
import utilities.CustomWaits;
import utilities.RandomCredentials;
import utilities.TakesScreenshots;

public class BaseClass {
    public WebDriver driver;
    public ConfigReader configReader;
    public CustomWaits wait;
    public RandomCredentials randomCredentials;
    public TakesScreenshots takesScreenshots;


    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-origin-");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        initializeUtilities();
        System.out.println("BeforeClass");
    }

    public void initializeUtilities() {
        configReader = new ConfigReader();
        wait = new CustomWaits(driver, configReader);

        takesScreenshots = new TakesScreenshots(driver, configReader.pathProperty("screenshotsPath"));
        randomCredentials = new RandomCredentials(5, 10);
        System.out.println("WebDriver initialized in setup: " + (driver != null));

    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        System.out.println("After Class");
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeMethod
    public void commonUrl() {
        if (driver != null) {
            System.out.println("Before Method");
            driver.get(configReader.getProperty("baseUrl"));
        } else {
            System.out.println("WebDriver is null in commonUrl");
        }

    }
}


