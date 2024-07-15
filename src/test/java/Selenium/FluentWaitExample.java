package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitExample {

    static WebDriver driver = new ChromeDriver();
    static WebElement element1, element2;
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriverSelenium\\chromedriver-win64\\chromedriver.exe");  //Specify the location in machine where the driver is located
        driver.get("https://www.allmovie.com/advanced-search");


        driver.manage().window().maximize();


                                                /* ----- EXPLICIT WAIT ------*/
        /* In FluentWait the command checks after time intervals if the web element is available or not*/
        

        /* Here we define first the "Wait" interface and it's methods are implemented by the "fluent" class
           a time out of duration fo the "interval's life"
           then the polling time (time duration of the intervals)
           and the ignoring no such element exception
         */

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);



        /* Then proceed to check if the web element exist by calling the WebElement "element" object
           to an anonymous class and defining a method to "apply" the argument, and return the web element
           to wait and apply to the WebElement

         */
        element1 = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver){
                return driver.findElement(By.xpath("//label[@for='genreid:100']"));
            }
        });

        /* Here we end the FluentWait by proceeding to action the element (by click)*/

        driver.findElement(By.xpath("//label[@for='genreid:100']")).click();


        element2 = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver){
                return driver.findElement(By.xpath("//a[@href='https://www.allmovie.com/movie/inception-am23858']"));
            }
        });

        driver.findElement(By.xpath("//a[@href='https://www.allmovie.com/movie/inception-am23858']"))
                .click();
    }
}
