package Test;

import Helpers.Helpers;
import Pages.PageLogin;
import Pages.PageLoginPFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
//import org.testng.annotations.Test;


public class NewTourPFactory1 {

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

    public void pruebaDos() throws IOException {

        PageLoginPFactory pageLoginPF = new PageLoginPFactory(driver);
        pageLoginPF.login("mercury","mercury");

        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/font")).getText().contains("Use our Flight Finder"));
    }

    @AfterMethod

    public void closeBrowser(){

        driver.close();
    }



}