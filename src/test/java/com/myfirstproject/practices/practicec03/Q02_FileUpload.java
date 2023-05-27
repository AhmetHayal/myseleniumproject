package com.myfirstproject.practices.practicec03;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Q02_FileUpload extends TestBase {
    /*
    Given
        Go to https://cgi-lib.berkeley.edu/ex/fup.html
    When
        Type "My File" into "Notes about the file" input
    And
        Click "Choose File" button
    And
        Select the file to upload
    And
        Click on "Press" button
    Then
        Assert that "Your notes on the file were" equals to "My File"
    And
        Assert that file content contains "Hello, I am uploaded file"
     */
    @Test
    public void uploadTest(){
//        Go to https://cgi-lib.berkeley.edu/ex/fup.html
        driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");

//        Type "My File" into "Notes about the file" input
        driver.findElement(By.name("note")).sendKeys("My File");

//        Click "Choose File" button
        WebElement chooseFile = driver.findElement(By.name("upfile"));

//        Select the file to upload
        String pathOfFile =  System.getProperty("user.home")+"\\Desktop\\text.txt";
        chooseFile.sendKeys(pathOfFile);

//        Click on "Press" button
        driver.findElement(By.xpath("//input[@type='submit']")).click();

//        Assert that "Your notes on the file were" equals to "My File"
        WebElement assert1 = driver.findElement(By.xpath("//blockquote"));
        Assert.assertEquals("My File",assert1.getText());

//        Assert that file content contains "Hello, I am uploaded file"
        WebElement assert2 = driver.findElement(By.xpath("//pre"));
        Assert.assertTrue(assert2.getText().contains("Hello, I am uploaded file"));
    }
}
