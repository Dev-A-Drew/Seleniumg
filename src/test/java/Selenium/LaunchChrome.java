package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchChrome {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriverSelenium\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriver driver1 = new ChromeDriver();
        driver1.get("https://www.google.com/");
        driver.get("https://www.amazon.com/");
        driver.close();
    }
}
