package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class SynchronizationWait {

    static WebDriver driver = new ChromeDriver();
    static WebElement element;


    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriverSelenium\\chromedriver-win64\\chromedriver.exe");  //Specify the location in machine where the driver is located

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        driver.get("https://www.allmovie.com/advanced-search");
        driver.manage().window().maximize();



        element = driver.findElement(By.xpath("//label[@for='genreid:100']"));
        element.click();

        element = driver.findElement(By.xpath("//*[@id=\"cmn_wrap\"]/div[1]/div[2]/section[2]/div[1]/table/tbody/tr[2]/td[1]/a"));
        element.click();









    }
}

