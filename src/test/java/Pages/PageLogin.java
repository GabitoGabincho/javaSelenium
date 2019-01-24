package Pages;

import Helpers.Helpers;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PageLogin {

    private WebDriver driver;
    private By userField;
    private By passField;
    private By loginButton;

    public  PageLogin(WebDriver driver) {
        this.driver = driver;
        userField = By.name("userName");
        passField  = By.name("password");
        loginButton = By.name("login");
    }

    public void login(String user, String pass) throws IOException {

      // File myScreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        driver.findElement(userField).sendKeys(user);
        driver.findElement(passField).sendKeys(pass);
        driver.findElement(loginButton).click();

      /*  try {
           FileUtils.copyFile(myScreenShot, new File("Login"+System.currentTimeMillis()+".png"));

        } catch (IOException e){ e.printStackTrace();}

      /*/
        //Helpers helper1 = new Helpers();
        //helper1.sleepSeconds(5);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
