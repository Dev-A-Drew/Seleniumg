package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriverSelenium\\chromedriver-win64\\chromedriver.exe");  //Specify the location in machine where the driver is located
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();


        Actions action1 = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(element);

        action1.dragAndDrop(driver.findElement(By.xpath("//div[@id='draggable']")),
                driver.findElement(By.xpath("//div[@id='droppable']"))).build().perform();





    }
}
