package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;


public class ToolQA
{
    private  WebDriver driver;

    @BeforeMethod

    private void setUp(){

        DesiredCapabilities caps = new DesiredCapabilities();
        System.setProperty("webdriver.chrome.driver","C:\\automation\\software\\chromedriver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://demoqa.com/");

        try {
            Thread.sleep(5000); }
        catch (InterruptedException e)
        {
            e.printStackTrace(); }
    }


    @org.testng.annotations.Test

    public void pruebaUno() {

       /* Find by LinkText */

       driver.findElement(By.linkText("Hello world!")).click();


        try {
            Thread.sleep(5000); }
        catch (InterruptedException e)
        {
            e.printStackTrace(); }

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"post-1\"]/div/p")).getText().contains("Welcome to WordPress."));
    }


    @AfterMethod

   public void closeBrowser(){

        driver.close();
    }



}
