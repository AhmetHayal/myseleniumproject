package com.myfirstproject.utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public abstract class TestBase {
    protected static WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    public void takeScreenshotOfEntirePage() throws IOException {
//        1. TakeScreenShot class with getScreenShotAs method to capture the screenshot
        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

//        2. Create a path to save the image
//          Create a date for giving dynamic name. Otherwise, the screenshots override.
        String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()); //Getting local date in this format
//                     CURRENT PROJECT FOLDER         foldername   subfoldername imagename
        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+now+"image.png";

//        3. Save the image in the path as a file
        FileUtils.copyFile(image, new File(path));
    }
/*
This method captures screenshots of specific elements.
This method accepts an element and saves the screenshot of that element in the test-output folder
 */
    public void takeScreenshotOfThisElement(WebElement element ) throws IOException {
        File image = element.getScreenshotAs(OutputType.FILE);
        String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/ElementScreenshots/"+now+"image.png";
        FileUtils.copyFile(image, new File(path));
    }
}