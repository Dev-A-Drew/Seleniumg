package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameExamples {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriverSelenium\\chromedriver-win64\\chromedriver.exe");  //Specify the location in machine where the driver is located
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_confirm");
        // Maximizing the window
        driver.manage().window().maximize();
        //defining an element to handle and target the frame

        WebElement element1 = driver.findElement(By.xpath("//*[@id=\"iframeResult\"]"));

        // Starting to interact with the frames using the element object
        driver.switchTo().frame(element1);
        // Sending the click action to the button and show the alert
        driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();

        //on the alert message we could click on "accept"
        driver.switchTo().alert().accept();

        //or clik on "dismiss"
        //driver.switchTo().alert().dismiss();






    }
}
