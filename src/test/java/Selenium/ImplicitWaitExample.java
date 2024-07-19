package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class ImplicitWaitExample {

    static WebDriver driver = new ChromeDriver();
    static WebElement element;


    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriverSelenium\\chromedriver-win64\\chromedriver.exe");  //Specify the location in machine where the driver is located



                                                /* ----- IMPLICIT WAIT ------*/


        /* Here we are setting the driver should wait "5" seconds before throw and exception if it doesn't find an
           element.
           The first code line below it's placed for that purpose, to be executed on the rest of the code*/

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //We get the web page
        driver.get("https://www.allmovie.com/advanced-search");
        //Maximize the chrome browser window
        driver.manage().window().maximize();
        //Find the checkbox id
        element = driver.findElement(By.xpath("//label[@for='genreid:100']"));
        element.click();
        //find the second element and click on the image/poster of the option
        element = driver.findElement(By.xpath("//*[@id=\"cmn_wrap\"]/div[1]/div[2]/section[2]/div[1]/table/tbody/tr[2]/td[1]/a"));
        element.click();









    }
}

