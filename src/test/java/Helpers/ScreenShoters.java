package Helpers;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShoters {

    public static void takeScreenshots(String screenName, WebDriver driver) {

            File myScreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(myScreenShot, new File(screenName+" "+System.currentTimeMillis()+".png"));

            } catch (IOException e){ e.printStackTrace();}
    }
}
