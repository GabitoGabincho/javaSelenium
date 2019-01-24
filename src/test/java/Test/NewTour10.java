package Test;

import Helpers.Helpers;
import Helpers.ScreenShoters;
import Helpers.WebDriverManager;
import Pages.PageLogin;
import Pages.PageLogon;
import Pages.PageReservation;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.json.Json;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;


import org.openqa.selenium.JavascriptExecutor;





import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;


public class NewTour10 {

    private  WebDriver driver;

    ArrayList<String> tabs;

    @BeforeMethod

    private void setUp(){
        DesiredCapabilities caps = new DesiredCapabilities();
        System.setProperty("webdriver.chrome.driver","C:\\automation\\software\\chromedriver\\chromedriver.exe");


        driver = new ChromeDriver();

        //WebDriverManager.setWindowSize(driver,"maximized");

        WebDriverManager.setWindowSize(400,100,driver);
        driver.navigate().to("http://newtours.demoaut.com/");

        // New tab
        //String googleWindow = "window.open('https://www.google.com.ar/')";
        //JavascriptExecutor jse = (JavascriptExecutor)driver;
        //jse.executeScript(googleWindow);

        //tabs = new ArrayList <String>(driver.getWindowHandles());

        Helpers helper1 = new Helpers();
        helper1.sleepSeconds(5);
    }



    @org.testng.annotations.Test

    public void pruebaUno() throws IOException {

        PageLogin pageLogin = new PageLogin(driver);
        PageReservation pageReservation = new PageReservation(driver);

        //pageLogin.login("mercury","mercury");

        pageLogin.login("mery","mer");

        pageReservation.assertPage();

        //driver.switchTo().window(tabs.get(1)).navigate().to("http://www.billboard.com");

        // activar otra tab

        //driver.switchTo().window(tabs.get(0)).navigate().to("http://www.nyt.com");

        //driver.switchTo().window(tabs.get(1));

    }



    @AfterMethod

    public void closeBrowser(ITestResult result){

        if(!result.isSuccess()){
            ScreenShoters.takeScreenshots("Errores ",driver);
        }

            driver.close();

        // Cerrar todos los tabs

        //driver.switchTo().window(tabs.get(0)).close();
        //Thread.sleep(1000);
        //driver.switchTo().window(tabs.get(1)).close();
}
}
