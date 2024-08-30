package Selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollExamples {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriverSelenium\\chromedriver-win64\\chromedriver.exe");  //Specify the location in machine where the driver is located
        WebDriver driver = new ChromeDriver();
        driver.get("https://stillstrom.com/");
        // Maximizing the window
        driver.manage().window().maximize();
        JavascriptExecutor js=(JavascriptExecutor) driver;

        js.executeScript("window.scroll(0,4500)");

    }
}
