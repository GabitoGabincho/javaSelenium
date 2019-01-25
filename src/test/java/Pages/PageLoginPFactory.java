/*
*   PAGE FACTORY FOR EACH ELEMENT
*
*   NEWTOUR 10
* */

package Pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PageLoginPFactory {

    private WebDriver driver;

    @FindBy(how = How.NAME, using ="userName") WebElement userFieldElement;
    @FindBy (how=How.NAME, using ="password") WebElement passFieldElement;
    @FindBy (how=How.NAME, using ="login") WebElement logFieldElement;;

    public  PageLoginPFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void login(String user, String pass) throws IOException {

        File myScreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        userFieldElement.sendKeys(user);
        //driver.findElement(userField).sendKeys(user);
        passFieldElement.sendKeys(pass);
        //driver.findElement(passField).sendKeys(pass);
        logFieldElement.click();
        //driver.findElement(loginButton).click();

        try {

           FileUtils.copyFile(myScreenShot, new File("LoginPFactory "+System.currentTimeMillis()+".png"));

        } catch (IOException e){ e.printStackTrace();}

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}

