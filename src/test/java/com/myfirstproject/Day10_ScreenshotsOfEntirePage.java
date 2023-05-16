package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.io.IOException;

public class Day10_ScreenshotsOfEntirePage extends TestBase {

//    CREATE A REUSABLE METHOD THAT WILL TAKE A SCREENSHOT IN THE TEST BASE-DONE
//    Extent Test Base
//    Copy the code from Day09 Auto Complete
//    Import the classes if you see any red
    @Test
    public void takeScreenshotOfPageTest() throws InterruptedException, IOException {
//        Given user is on https://testcenter.techproeducation.com/index.php?page=autocomplete
        driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");

//        When user type “uni” in the search box
        //TAKE SCREENSHOT
        takeScreenshotOfEntirePage();

        driver.findElement(By.id("myCountry")).sendKeys("uni");
        Thread.sleep(2000);

//        And select the ‘United Kingdom’ from the suggestions
        //TAKE SCREENSHOT
        takeScreenshotOfEntirePage();

        //TAKING SCREENSHOT OF ONLY UNITED KINGDOM ELEMENT
        takeScreenshotOfThisElement(driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//*[.='United Kingdom']")));

        driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//*[.='United Kingdom']")).click();
        Thread.sleep(2000);

//        And click on submit button
        //TAKE SCREENSHOT
        //takeScreenshotOfEntirePage();

        takeScreenshotOfEntirePage();
        driver.findElement(By.xpath(" //input[@type='button']")).click();
        Thread.sleep(2000);
        //TAKE SCREENSHOT

//        Then verify the result contains "United Kingdom"
        //takeScreenshotOfPageTest();

        //TAKING SCREENSHOT OF RESULT ELEMENT
        takeScreenshotOfThisElement(driver.findElement(By.id("result")));

        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains("United Kingdom"));
        takeScreenshotOfEntirePage();
    }
}
