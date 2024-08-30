package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitExample {
    static WebDriver driver = new ChromeDriver();
    static WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(6));
    static WebElement element;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriverSelenium\\chromedriver-win64\\chromedriver.exe");  //Specify the location in machine where the driver is located
        driver.get("https://www.allmovie.com/advanced-search");
        driver.manage().window().maximize();


                                                    /* ----- EXPLICIT WAIT ------*/



        /* The difference in the "ExplicitWait" is to be more flexible to allow the wait fulfill the specific condition
         before move on to the next code line.
         If the condition is not met the time, the exception is thrown */



        //Establish one condition to wait until the web element is loaded, in this case for the xpath element below
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='genreid:100']")));
        //After the "wait" conditions has been executed, we move forward to locate and find the element to click it
        element=driver.findElement(By.xpath("//label[@for='genreid:100']"));
        element.click();


        //Doing the same thing, defining the wait only focus on the next web element to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cmn_wrap\"]/div[1]/div[2]/section[2]/div[1]/table/tbody/tr[2]/td[1]/a")));
        //Wait until the condition has been executed and click on the element
        element = driver.findElement(By.xpath("//*[@id=\"cmn_wrap\"]/div[1]/div[2]/section[2]/div[1]/table/tbody/tr[2]/td[1]/a"));
        element.click();


    }
}
