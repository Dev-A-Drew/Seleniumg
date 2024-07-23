package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MoviesExample {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriverSelenium\\chromedriver-win64\\chromedriver.exe");  //Specify the location in machine where the driver is located
        WebDriver driver = new ChromeDriver();

        driver.get("https://cinecenter.com.bo/");
        // Maximizing the window
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
        WebElement element1 = wait.until
                (ExpectedConditions.elementToBeClickable
                (By.xpath("//*[@id=\"contentModal-promo-proyecta\"]/div/div/div[1]/button")));
        // driver.switchTo().frame(element1);
        // driver.findElement(By.xpath("']")).click();
        element1.click();


    }
}
