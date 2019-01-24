package Test;

import Helpers.Helpers;
import Pages.PageLogin;
import Pages.PageLogon;
import Pages.PageReservation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.TakesScreenshot;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;


public class NewTour7 {

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

    @org.testng.annotations.Test

    public void pruebaCuatro() throws IOException {
        PageLogin pageLogin = new PageLogin(driver);
        PageReservation pageReservation = new PageReservation(driver);

        pageLogin.login("mercury","mercury");
        pageReservation.assertPage();

        pageReservation.tipoViaje();
        pageReservation.selectPasaje(2);
        pageReservation.selectFromPort(3);
        pageReservation.selectFechaSalida(5,23);
        pageReservation.selectToPort("London");
        pageReservation.selectFechaRetorno(6,28);
        pageReservation.selectServiceClas();
        pageReservation.selectAirline("Pangea Airlines");
    }

      @AfterMethod

      public void closeBrowser(){
          driver.close();
      }



}
