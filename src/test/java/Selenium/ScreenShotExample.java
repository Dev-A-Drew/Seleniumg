package Selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class ScreenShotExample {

    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriverSelenium\\chromedriver-win64\\chromedriver.exe");  //Specify the location in machine where the driver is located
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.brumate.com/");
        // Maximizing the window
        driver.manage().window().maximize();
        //we define an object from Files library
        File screen1File=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screen1File,new File("E:\\Java IntelliJ\\Seleniumg\\screen1.jpg"));


        //Now we will take a partial screenshot from an element
        WebElement element1= driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/section[2]/div/div/div/div[1]"));
        File screenFile2=element1.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenFile2, new File("E:\\Java IntelliJ\\Seleniumg\\sliderWeb1.jpg"));
    }
}
