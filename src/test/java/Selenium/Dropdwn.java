package Selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.channels.Selector;
import java.time.Duration;

public class Dropdwn {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriverSelenium\\chromedriver-win64\\chromedriver.exe");  //Specify the location in machine where the driver is located
        WebDriver driver = new ChromeDriver();

        //opening the web page
        driver.get("https://www.boa.bo/BoAWebsite");
        //Maximize the winddow
        //driver.manage().window().maximize();
        //Instanciate an object from WebDriverWait to wait the page load
        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(10));
        //Use the wait object in the element object to click in the dropdown
        WebElement elementoD = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='select_desde']")));

        //WebElement elementoD = driver.findElement(By.xpath("//select[@id='select_desde']"));
        //WebElement elementoD = driver.findElement(By.cssSelector("#select_desde"));

        //Define a selector object
        Select selectorD = new Select(elementoD);
        //Try with different types of selectors on the dropdown list
        selectorD.selectByValue("CBB");
        Thread.sleep(1000);
        selectorD.selectByVisibleText("BARCELONA");
        Thread.sleep(1000);
        selectorD.selectByIndex(13);
        Thread.sleep(1000);

                                //--------- WE GO TO THE DESTINY AUTOMATION ----------

        WebElement elementoT = wait.until(ExpectedConditions.elementToBeClickable(By.id("select_hasta")));
        Select selectorT = new Select(elementoT);
        selectorT.selectByValue("ORU");
        Thread.sleep(1000);
        selectorT.selectByIndex(9);
        Thread.sleep(1000);
        selectorT.selectByVisibleText("TARIJA");
        Thread.sleep(1000);

        //close window
        driver.close();
    }
}
