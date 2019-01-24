package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PageLoginPFactory {

    private WebDriver driver;


    @FindBy(how = How.NAME, using ="userName") WebElement userFieldElement;
    //private By userField;

    @FindBy (how=How.NAME, using ="password") WebElement passFieldElement;
    //private By passField;


    @FindBy (how=How.NAME, using ="login") WebElement logFieldElement;;
    //private By loginButton;






    public  PageLoginPFactory(WebDriver driver){ //, WebElement userFieldElement, WebElement passFieldElement, WebElement logFieldElement) {
        this.driver = driver;
        /*userField = By.name("userName");
         passField  = By.name("password");
         loginButton = By.name("login");*/

        PageFactory.initElements(driver,this);
    }

    public void login(String user, String pass) throws IOException {

        // File myScreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        userFieldElement.sendKeys(user);
        //driver.findElement(userField).sendKeys(user);
        passFieldElement.sendKeys(pass);
        //driver.findElement(passField).sendKeys(pass);
        logFieldElement.click();
        //driver.findElement(loginButton).click();

      /*  try {
           FileUtils.copyFile(myScreenShot, new File("Login"+System.currentTimeMillis()+".png"));

        } catch (IOException e){ e.printStackTrace();}

      /*/
        //Helpers helper1 = new Helpers();
        //helper1.sleepSeconds(5);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}

