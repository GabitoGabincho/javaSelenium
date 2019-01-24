package Helpers;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

public class WebDriverManager {

    public static void setWindowSize(WebDriver driver, String sizes){

        if(sizes =="maximized"){
            driver.manage().window().maximize();
        }
        if (sizes=="Fullscreen"){
            driver.manage().window().fullscreen();
        }
    }

    public static void setWindowSize(int x, int y, WebDriver driver){

        driver.manage().window().setPosition(new Point(x,y));

    }
}
