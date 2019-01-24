package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class PageReservation {

    private WebDriver driver;

    private By tittleText2;
    private By toDrop;
    private By fromDrop;
    private By passangersDrop;
    private By mesSalida;
    private By diaSalida;
    private By mesLlegada;
    private By diaLlegada;
    private By seviceClass;
    private By aerlines;
    private By viaje;


    // Constructor

    public PageReservation(WebDriver driver){
        this.driver = driver;
        tittleText2 = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/font");

        passangersDrop = By.name("passCount");
        fromDrop = By.name("fromPort");
        toDrop = By.name("toPort");

        mesSalida = By.name("fromMonth");
        diaSalida = By.name("fromDay");

        mesLlegada = By.name("toMonth");
        diaLlegada = By.name("toDay");

        viaje = By.name("tripType");
        seviceClass = By.name("servClass");
        aerlines = By.name("airline");
    }

    public void assertPage(){
        Assert.assertTrue(driver.findElement(tittleText2).getText().contains("Use our Flight Finder")); }

    // Select Tipo de Viaje

    public void tipoViaje(){
        List<WebElement> list = driver.findElements(viaje);
        Boolean is_selected = list.get(0).isSelected();
        if(is_selected == true){ list.get(1).click();}
        else {list.get(1).click();}
        }

    // Select Cantidad Pasajeros

    public void selectPasaje(int cant){
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement cantidadPasajero = wait.until(ExpectedConditions.presenceOfElementLocated(passangersDrop));

        Select selectPasajeros = new Select(driver.findElement(passangersDrop));
        //Select selectPasajeros = new Select(driver.findElement(cantidadPasajero));
        selectPasajeros.selectByVisibleText(Integer.toString(cant));
    }

    // Select lugar de Salida

    public void selectFromPort (int ind){

        Select selectFrom = new Select(driver.findElement(fromDrop));
        selectFrom.selectByIndex(ind);
    }

    // Select Fecha de Salida

    public void selectFechaSalida(int m, int d){
        Select selectMesSalida = new Select(driver.findElement(mesSalida));
        selectMesSalida.selectByIndex(m);

        Select selectDiaSalida = new Select(driver.findElement(diaSalida));
        selectDiaSalida.selectByIndex(d);
    }

    // Select Lugar de llegada

    public void selectToPort(String city){
        Select selectTo = new Select(driver.findElement(toDrop));
        selectTo.selectByValue(city);
    }

    // Select Fecha de Llegada

    public void selectFechaRetorno(int mm, int dd){
        Select selectMesSalida = new Select(driver.findElement(mesLlegada));
        selectMesSalida.selectByIndex(mm);

        Select selectDiaSalida = new Select(driver.findElement(diaLlegada));
        selectDiaSalida.selectByIndex(dd);
    }

    // Select Servicio

    public void selectServiceClas(){
        List<WebElement> list = driver.findElements(seviceClass);
        Boolean is_selected = list.get(0).isSelected();
        if(is_selected == true){ list.get(2).click();}
        else {list.get(2).click();}
    }

    // Select Aerolineas

    public void selectAirline(String aerolineas){
        Select selectAerolineas = new Select(driver.findElement(aerlines));
        selectAerolineas.selectByVisibleText(aerolineas);

    }

}
