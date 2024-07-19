package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MouseActionsExample {


    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriverSelenium\\chromedriver-win64\\chromedriver.exe");  //Specify the location in machine where the driver is located
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.brumate.com/");
        // Maximizing the window
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Actions action1 = new Actions(driver);
        action1.moveToElement(driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div[1]/nav/a[1]"))).build().perform();

        action1.moveToElement(driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div[1]/nav/a[2]"))).build().perform();

        action1.moveToElement(driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div[1]/nav/a[3]"))).build().perform();

        action1.moveToElement(driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div[1]/nav/div"))).build().perform();
        // click on the loupe
        action1.moveToElement(driver.findElement(By.xpath("//button[@data-comp='CtaSearch']"))).click().build().perform();
        // type cooler and select the word
        action1.moveToElement(driver.findElement(By.xpath("//input[@role='search']"))).click().sendKeys("Cooler").doubleClick().build().perform();

        // in case to short the code line, the alternative below about DoubleClicl
        //action1.doubleClick(driver.findElement(By.xpath("//input[@role='search']")))

        action1.moveToElement(driver.findElement(By.xpath("//*[@id=\"__next\"]/aside[1]/div/div[1]/div/div/button"))).click().build().perform();

        //action1.moveToElement(driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div[1]/nav/a[5]"))).contextClick().build().perform();
        //Same case if it is needed a shor code length
        action1.contextClick(driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div[1]/nav/a[5]"))).build().perform();;
    }
}
