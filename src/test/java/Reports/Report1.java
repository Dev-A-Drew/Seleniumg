package Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.*;

public class Report1 {
    static WebDriver driverA;
    public static void main(String[] args) throws IOException {
        // Some kind like engine, which is the instantiation of the ExtendReports Class
        ExtentReports extentReportA = new ExtentReports();

        /*
                        OPTION 1 TO GENERATE REPORT: Path to generate the html report by String path

        ExtentSparkReporter sparkReporterB = new ExtentSparkReporter
                                             ("E:\\Java IntelliJ\\P_O_M-JavaSelenium1\\src\\ReportNameOfTestOrSuit.html");
        extentReportA.attachReporter(sparkReporterB);
        extentReportA.flush(); //Method to generate the html report
        Desktop.getDesktop().browse(new File("E:\\Java IntelliJ\\P_O_M-JavaSelenium1\\src\\ReportNameOfTestOrSuit.html").toURI());
        */


        //OPTION 2 TO GENERATE REPORT: Using File instance

        File fileC = new File("E:\\Java IntelliJ\\Seleniumg\\src\\ReportNameOfTestOrSuit.html");
        ExtentSparkReporter sparkReporterB = new ExtentSparkReporter(fileC);
        extentReportA.attachReporter(sparkReporterB);



                                                //Test - 1 -> Types of status




        ExtentTest testD1 = extentReportA
                            .createTest("TestCase - 1")
                            .log(Status.INFO,"Info-1")
                            .log(Status.PASS, "<b>Info-Pass</b>")
                            .log(Status.WARNING,"<i>Info Warning</i>")
                            .log(Status.SKIP,"<b><i>Info-Skip</i></b>")
                            .log(Status.FAIL, "Info-Fail");
        testD1.pass("This Test1 is passed");



                                                //Test - 2 -> Status




        ExtentTest testD2 = extentReportA.createTest("TestCase - 2");
        testD2.log(Status.FAIL, "This is a failed test, as the developer why");



                                                //Test - 3




        ExtentTest testD3 = extentReportA.createTest("TestCase - 3")
                            .skip("This is a manipulated skipped test");




                                                //Test - 4 -> XML scenario




        ExtentTest testD4;
        String xmlData = "<menu id=\"file\" value=\"File\">\n" +
                         "  <popup>\n" +
                         "    <menuitem value=\"New\" onclick=\"CreateNewDoc()\" />\n" +
                         "    <menuitem value=\"Open\" onclick=\"OpenDoc()\" />\n" +
                         "    <menuitem value=\"Close\" onclick=\"CloseDoc()\" />\n" +
                         "  </popup>\n" +
                         "</menu>";
        extentReportA.createTest("TestCase - XML")
                     .log(Status.INFO,xmlData)
                     .info(MarkupHelper.createCodeBlock(xmlData, CodeLanguage.XML));




                                                //Test - 5 -> JSON Scenario




        ExtentTest testD5;
        String jsonData ="{\"menu\": {\n" +
                         "  \"id\": \"file\",\n" +
                         "  \"value\": \"File\",\n" +
                         "  \"popup\": {\n" +
                         "    \"menuitem\": [\n" +
                         "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\n" +
                         "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\n" +
                         "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\n" +
                         "    ]\n" +
                         "  }\n" +
                         "}}";
        extentReportA.createTest("TestCase - JSON")
                     .log(Status.INFO,MarkupHelper.createCodeBlock(jsonData,CodeLanguage.JSON));



                                                //Test - 6 -> List Scenario




        List<String> listData = new ArrayList<>();
        listData.add("Andrew");
        listData.add("Shawn");
        listData.add("Marcus");
        extentReportA.createTest("TestCase -Oordered/Unordered List")
                     .info(MarkupHelper.createOrderedList(listData))
                     .info(MarkupHelper.createUnorderedList(listData));



                                                //Test - 7 -> Map Scenario




        Map<Integer,String> mapData = new HashMap<>();
        mapData.put(101,"Jason");
        mapData.put(102,"Yelena");
        mapData.put(103,"Robert");
        extentReportA.createTest("TestCase - MapData List")
                     .info(MarkupHelper.createOrderedList(mapData))
                     .info(MarkupHelper.createUnorderedList(mapData));




                                                //Test - 8 -> Set List Scenario




        Set<Integer> setData = mapData.keySet();
        extentReportA.createTest("TestCase - SetData List")
                     .info(MarkupHelper.createOrderedList(setData))
                     .info(MarkupHelper.createUnorderedList(setData));



                                                //Test - 9 -> highlighted text




        extentReportA.createTest("Highlight log test")
                     .info(MarkupHelper.createLabel("This is a highlighted message", ExtentColor.BLUE))
                     .info("This is not a highlighted message");




                                                //Test - 10 -> Throwable exceptions




        try {int i=5/0;}
        catch (Exception e)
        {
            extentReportA.createTest("Test Exception")
                         .fail(e);
        }
        Throwable t = new RuntimeException("This is a custom exception");
        extentReportA.createTest("Custom Test Exception")
                     .fail(t);



                                                //Test - 11 -> Screenshots AT TEST LEVEL




        WebDriverManager.chromedriver().setup();
        driverA = new ChromeDriver();
        driverA.get("https://google.com");
        String base64Code = captureScreenshot();
        String pathCapture = captureScreenshot("Google.png");


        extentReportA
                .createTest("Screenshot Test 1","This is a test for screenshot of the test ")
                .info("This is a info message")
                .addScreenCaptureFromBase64String(base64Code);


        extentReportA
                .createTest("Screenshot Test 2","This is a test for screenshot of the test ")
                .info("This is a info message")
                .addScreenCaptureFromBase64String(base64Code, "Google homepage screenshot");


        extentReportA
                .createTest("Screenshot Test 3","This is a test for screenshot of the test ")
                .info("This is a info message")
                .addScreenCaptureFromBase64String(base64Code, "Google homepage screenshot 1")
                .addScreenCaptureFromBase64String(base64Code, "Google homepage screenshot 2")
                .addScreenCaptureFromBase64String(base64Code, "Google homepage screenshot 3");


        extentReportA
                .createTest("Screenshot Test 4","This is a test for screenshot of the test ")
                .info("This is a info message")
                .addScreenCaptureFromPath(pathCapture);


        extentReportA
                .createTest("Screenshot Test 5","This is a test for screenshot of the test ")
                .info("This is a info message")
                .addScreenCaptureFromPath(pathCapture, "Google homepage screenshot with path");


        extentReportA
                .createTest("Screenshot Test 6","This is a test for screenshot of the test ")
                .info("This is a info message")
                .addScreenCaptureFromPath(pathCapture, "Google homepage screenshot with path 1")
                .addScreenCaptureFromPath(pathCapture, "Google homepage screenshot with path 2")
                .addScreenCaptureFromPath(pathCapture, "Google homepage screenshot with path 3")
                .addScreenCaptureFromPath(pathCapture, "Google homepage screenshot with path 4");


        

                                                // Test 12  - screenshots at LOG LEVEL




        extentReportA
                .createTest("Screenshot Test 7 LOG LEVEL","This is a test for screenshot of the test ")
                .info("This is a info message")
                .fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code).build())
                .fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code,"Google homapage LOG").build());

        extentReportA
                .createTest("Screenshot Test 8 LOG LEVEL","This is a test for screenshot of the test ")
                .info("This is a info message")
                .fail(MediaEntityBuilder.createScreenCaptureFromPath(pathCapture).build())
                .fail(MediaEntityBuilder.createScreenCaptureFromPath(pathCapture,"Google homepage LOG").build());

        extentReportA
                .createTest("Screenshot Test 9 LOG LEVEL","This is a test for screenshot of the test ")
                .info("This is a info message")
                .fail("This is a fail method message",MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code).build())
                .fail("This is a fail method message",MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code,"Google homapage LOG").build());

        extentReportA
                .createTest("Screenshot Test 10 LOG LEVEL","This is a test for screenshot of the test ")
                .info("This is a info message")
                .fail("This is a fail method message",MediaEntityBuilder.createScreenCaptureFromPath(pathCapture).build())
                .fail("This is a fail method message", MediaEntityBuilder.createScreenCaptureFromPath(pathCapture,"Google homepage LOG").build());


        Throwable errorZ = new Throwable("This is a Throwable message");
        extentReportA
                .createTest("Screenshot Test 11 LOG LEVEL Throwable","This is a test for screenshot of the test ")
                .info("This is a info message")
                .fail(errorZ,MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code).build())
                .fail(errorZ,MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code,"Google homapage LOG").build());

        extentReportA
                .createTest("Screenshot Test 12 LOG LEVEL Throwable","This is a test for screenshot of the test ")
                .info("This is a info message")
                .fail(errorZ,MediaEntityBuilder.createScreenCaptureFromPath(pathCapture).build())
                .fail(errorZ, MediaEntityBuilder.createScreenCaptureFromPath(pathCapture,"Google homepage LOG").build());










        extentReportA.flush();
        driverA.quit();
        Desktop.getDesktop().browse(new File("E:\\Java IntelliJ\\Seleniumg\\src\\ReportNameOfTestOrSuit.html").toURI());
    }


                                            // METHODS FOR TEST 11
    public static String captureScreenshot(String fileName)
    {
        TakesScreenshot takeScreenshot = (TakesScreenshot) driverA;
        File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("./Screenshots/"+fileName);
        try{FileUtils.copyFile(sourceFile,destinationFile);}
        catch (IOException e) {e.printStackTrace();}
        System.out.println("Screenshot saved successfully");
        return destinationFile.getAbsolutePath();
    }

    public static String captureScreenshot()
    {
        TakesScreenshot takeScreenshot = (TakesScreenshot) driverA;
        String base64Code = takeScreenshot.getScreenshotAs(OutputType.BASE64);
        System.out.println("Screenshot saved successfully");
        return base64Code;
    }


}
