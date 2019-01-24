package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;


public class Test {

    private  WebDriver driver;

    @BeforeMethod

    private void setUp(){

        DesiredCapabilities caps = new DesiredCapabilities();
        System.setProperty("webdriver.chrome.driver","C:\\automation\\software\\chromedriver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://es-la.facebook.com/");

        try { Thread.sleep(5000);
            }
        catch (InterruptedException e){
          e.printStackTrace(); }
    }


    @org.testng.annotations.Test

    public void pruebaUno() {

        driver.findElement(By.name("email")).sendKeys("xxx");
        driver.findElement(By.name("pass")).sendKeys("ccc");
        driver.findElement(By.id("u_0_2")).click();

        try {
            Thread.sleep(5000); }
        catch (InterruptedException e)
        {
            e.printStackTrace(); }

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"error_box\"]/div[1]")).getText().contains("Vuelve a intentarlo más tarde"));
    }

    @org.testng.annotations.Test

    public void pruebaDos() {
        driver.findElement(By.name("email")).sendKeys("gabito_onj@hotmail.com");
        driver.findElement(By.name("pass")).sendKeys("olivia2018");
        driver.findElement(By.id("u_0_2")).click();

        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"u_0_a\"]/div[1]/div[1]/div/a/span/span")).getText().contains("Gabito"));
    }

    @AfterMethod

    public void closeBrowser(){

        driver.close();
    }



}
