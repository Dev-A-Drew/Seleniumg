package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class parabankSiteLogin {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriverSelenium\\chromedriver-win64\\chromedriver.exe");  //Specify the location in machine where the driver is located
        WebDriver driver = new ChromeDriver();                                                                           //Creating a new object to handle chrome
        driver.get("https://parabank.parasoft.com/parabank/index.htm");                                                  //entering parabank site
        driver.findElement(By.name("username")).sendKeys("john");                                             //typing username
        driver.findElement(By.name("password")).sendKeys("demo");                                             // typing password
        driver.findElement(By.cssSelector(".button:nth-child(1)")).click();                                              // clicking button to "login"

        driver.findElement(By.linkText("Log Out")).click();                                                              // Clicking "log out" link
    }
}
