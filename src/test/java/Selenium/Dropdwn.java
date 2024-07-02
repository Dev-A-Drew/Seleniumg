package Selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;


public class Dropdwn {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriverSelenium\\chromedriver-win64\\chromedriver.exe");  //Specify the location in machine where the driver is located
        WebDriver driver = new ChromeDriver();

        //opening the web page
        driver.get("https://www.boa.bo/BoAWebsite");

        //Maximize the winddow
        //driver.manage().window().maximize();

        //Instantiating an object from WebDriverWait to wait the page load
        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(5));
        //Use the wait object in the element object to click in the dropdown
        WebElement elementoD = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='select_desde']")));


        //Define a selector object
        Select selectorD = new Select(elementoD);
        //Try with different types of selectors on the dropdown list
        selectorD.selectByValue("CBB");
        Thread.sleep(1000);
        selectorD.selectByVisibleText("BARCELONA");
        Thread.sleep(1000);
        selectorD.selectByIndex(13);
        Thread.sleep(1000);

                                //--------- WE GO TO THE DESTINY SELECTION ----------

        WebElement elementoT = wait.until(ExpectedConditions.elementToBeClickable(By.id("select_hasta")));
        Select selectorT = new Select(elementoT);
        selectorT.selectByValue("ORU");
        Thread.sleep(1000);
        selectorT.selectByIndex(9);
        Thread.sleep(1000);
        selectorT.selectByVisibleText("TARIJA");
        Thread.sleep(1000);


                                //---------INTERACTING WITH THE CHECK BOXES ---------//
        //Alternative with Xpath to find the radio button
        //WebElement radio1 = driver.findElement(By.xpath("//div[@id='rbtn_ida']/div"));

        //Define a new object for radio button pointing the selector
        WebElement radio1 = driver.findElement(By.id("rbtn_ida"));
        //The code will make click
        radio1.click();
        //Implement a system message of the executed action
        System.out.println("Se ha seleccionado SOLO IDA correectamente");
        //A wait of 2 seconds before click back the default radio button selected (Ida y vuelta)
        Thread.sleep(2000);
        //Pointing back to the respective selector in the page
        radio1 = driver.findElement(By.id("rbtn_ida_vuelta"));
        //Click in the radio button
        radio1.click();
        //Message of the executed action
        System.out.println("Se ha vuelto a seleccionar IDA Y VUELTA correctamente");





                                // --------INTERACTING WITH THE DATE PICKER---------//
        //Defining an object to manipulate the calendar option
        WebElement dateSel = driver.findElement(By.xpath("//*[@id=\"picker_salida\"]"));
        dateSel.click();
        //Set the month and year
        String selmonthIda="Julio";
        String selYearIda="2024";


        //Defining Strings to select the month and year from the page
        String theMonthIda = driver.findElement(By.xpath("//div[@id=\"ui-datepicker-div\"]/div[1]/div/div/span[1]")).getText();
        String theYearIda = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/div/span[2]")).getText();
        //Comparing the local variables with the web variables
        if(theMonthIda.equals(selmonthIda) && theYearIda.equals(selYearIda))
        {
            //Dividing the Xpath in 2 click to low the charge and improve performance of code
            driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//table[@class='ui-datepicker-calendar']//td")).click();
            driver.findElement(By.xpath("//td[@data-handler='selectDay']//a[text()='9']")).click();
        }


        //Same procedure as before for the return date
        WebElement dateRet = driver.findElement(By.xpath("//*[@id=\"picker_regreso\"]"));
        dateRet.click();
        String selMonthVuelta="Agosto";
        String selYearVuelta="2024";

        String theMonthVuelta = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/div/div/span[1]")).getText();
        String theYearVuelta = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/div/div/span[2]")).getText();
        if(theMonthVuelta.equals(selMonthVuelta) && theYearVuelta.equals(selYearVuelta))
        {
            driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-last']//table[@class='ui-datepicker-calendar']//td")).click();
            driver.findElement(By.xpath("//td[@data-handler='selectDay']//a[text()='5']")).click();
        }
        

        //close window
        //driver.close();
    }
}
