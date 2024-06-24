package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

public class parabankSiteLogin {


    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriverSelenium\\chromedriver-win64\\chromedriver.exe");  //Specify the location in machine where the driver is located
        WebDriver driver = new ChromeDriver();                                                                           //Creating a new object to handle chrome
        driver.get("https://parabank.parasoft.com/parabank/index.htm");                                                  //entering parabank site
        driver.findElement(By.name("username")).sendKeys("john");                                             //typing username
        driver.findElement(By.name("password")).sendKeys("demo");                                             //typing password
        driver.findElement(By.cssSelector(".button:nth-child(1)")).click();                                              //clicking button to "login"
        driver.findElement(By.linkText("Transfer Funds")).click();                                                       //click on transfer funds link



        //                             ----- Using CSS Selectors and XPath -----
        //1. Basic way
        //driver.findElement(By.cssSelector("input[id='amount']")).sendKeys("2000");                                     //typing an amount by CSSSelector
        //driver.findElement(By.cssSelector("input[id*='amo']")).sendKeys("2000");                                       //Using SubStrings
        driver.findElement(By.cssSelector("input[id='amount']:nth-child(2)")).sendKeys("2000");               //Using Index




        //2. With inspect (extension)
        //driver.findElement(By.cssSelector("#amount")).sendKeys("4000");                                                //using another amount by XPath
        driver.findElement(By.xpath("//input[contains(@id,'amount')]")).sendKeys("3000");        //Using SubString

        driver.findElement(By.linkText("Log Out")).click();                                                            // Clicking "log out" link


        /* It will be adding the keys but the
        goal in this scrip is to test different
        types of sendKeys using Xpath and
        CSSSelector
         */
    }
}
