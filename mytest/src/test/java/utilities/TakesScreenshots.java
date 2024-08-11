package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class TakesScreenshots {
    private final WebDriver driver;
    private final String screenshotsPath;

    public TakesScreenshots(WebDriver driver, String screenshotsPath){
        this.driver = driver;
        this.screenshotsPath = screenshotsPath;
    }
    public String captureScreenshot(String filename){
        TakesScreenshot screenshot = (TakesScreenshot) driver;
       File file =   screenshot.getScreenshotAs(OutputType.FILE);
       try{
        Files.createDirectories(Paths.get(screenshotsPath).getParent());
           FileUtils.copyFile(file,new File(screenshotsPath+File.separator+filename));
       }
       catch (IOException e){
           e.printStackTrace();
           System.out.println("Failed to save Screenshot:"+e.getMessage());
       }
        return filename;
    }

    }
