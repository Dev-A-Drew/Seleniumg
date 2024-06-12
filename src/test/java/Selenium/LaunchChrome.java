package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchChrome {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriverSelenium\\chromedriver-win64\\chromedriver.exe"); //Specidy the location in machine where the driver is located
        WebDriver driver = new ChromeDriver();          //Creating a new object to handle chrome
        driver.get("https://www.amazon.com");          //telling the object to open the browser in the URL
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Headphones");        //Ordering the object to find the textfield for search and write what we want
        driver.findElement(By.id("nav-search-submit-button")).click();            //Ordering the object to click on "search" button
        //driver.findElement(By.className("a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal")).click();


    }
}
