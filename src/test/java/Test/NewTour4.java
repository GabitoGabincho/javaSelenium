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


public class NewTour4 {

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

        PageLogin pageLogin = new PageLogin(driver);
        PageLogon pageLogon = new PageLogon(driver);

        pageLogin.login("xxx","xxx");
        pageLogon.assertLogonPage();

    }

    @org.testng.annotations.Test

    public void pruebaDos() throws IOException {
        PageLogin pageLogin = new PageLogin(driver);
        PageReservation pageReservation = new PageReservation(driver);

        pageLogin.login("mercury","mercury");
        pageReservation.assertPage();
    }

    @org.testng.annotations.Test

    public void pruebaTres() throws IOException {
        PageLogin pageLogin = new PageLogin(driver);
        PageReservation pageReservation = new PageReservation(driver);

        pageLogin.login("mercury","mercury");
        pageReservation.assertPage();

        pageReservation.selectPasaje(2);
        pageReservation.selectFromPort(3);
        pageReservation.selectToPort("London");
    }

  //  @AfterMethod

  //  public void closeBrowser(){

  //      driver.close();
  //  }



}
