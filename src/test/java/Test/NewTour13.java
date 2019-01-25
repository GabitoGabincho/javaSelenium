package Test;

import Helpers.Helpers;
import Helpers.ScreenShoters;
import Helpers.WebDriverManager;
import Pages.PageLogin;

import Pages.PageLoginPFactory;
import Pages.PageReservation;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//import org.testng.annotations.Test;


import java.io.IOException;
import java.util.ArrayList;


public class NewTour13 {
    private WebDriver driver;

    public NewTour13() {
    }

    @BeforeMethod
    private void setUp() {
        new DesiredCapabilities();
        System.setProperty("webdriver.chrome.driver", "C:\\automation\\software\\chromedriver\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.navigate().to("http://newtours.demoaut.com/");
        Helpers helper1 = new Helpers();
        helper1.sleepSeconds(5);
    }

    @Test
    public void pruebaDos() throws IOException {
        PageLogin pageLoginPF = new PageLogin(this.driver);
        pageLoginPF.login("mercury", "mercury");
        Assert.assertTrue(this.driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/font")).getText().contains("Use our Flight Finder"));
    }

    @Test
    public void pruebaTitulo() throws IOException {
        PageLogin pageLoginPF = new PageLogin(this.driver);
        pageLoginPF.putTittle();
    }

    @AfterMethod
    public void closeBrowser() {
        this.driver.close();
    }
}
