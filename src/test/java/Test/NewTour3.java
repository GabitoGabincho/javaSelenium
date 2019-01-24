package Test;

import Helpers.Helpers;
import Pages.PageLogin;
import Pages.PageLogon;
import Pages.PageReservation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
//import org.testng.annotations.Test;


public class NewTour3 {

    private  WebDriver driver;

    @BeforeMethod

    private void setUp(){

        DesiredCapabilities caps = new DesiredCapabilities();
        System.setProperty("webdriver.chrome.driver","C:\\automation\\software\\chromedriver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://newtours.demoaut.com/");

        Helpers helper1 = new Helpers();
        helper1.sleepSeconds(5);
    }


    @org.testng.annotations.Test

    public void pruebaUno() throws IOException {

        //driver.findElement(By.name("userName")).sendKeys("xxx");
        //driver.findElement(By.name("password")).sendKeys("ccc");
        //driver.findElement(By.name("login")).click();

        //Helpers helper1 = new Helpers();
        //helper1.sleepSeconds(5);

        PageLogin pageLogin = new PageLogin(driver);
        PageLogon pageLogon = new PageLogon(driver);

        pageLogin.login("xxx","xxx");
        pageLogon.assertLogonPage();
        //Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p/font/b")).getText().contains("Welcome back to Mercury Tours!"));
    }

    @org.testng.annotations.Test

    public void pruebaDos() throws IOException {
        //driver.findElement(By.name("userName")).sendKeys("mercury");
        //driver.findElement(By.name("password")).sendKeys("mercury");
        //driver.findElement(By.name("login")).click();

        //Helpers helper1 = new Helpers();
        //helper1.sleepSeconds(4);

        PageLogin pageLogin = new PageLogin(driver);
        PageReservation pageReservation = new PageReservation(driver);

        pageLogin.login("mercury","mercury");
        pageReservation.assertPage();

        //Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/font")).getText().contains("Use our Flight Finder"));
    }

    @AfterMethod

    public void closeBrowser(){

        driver.close();
    }



}
