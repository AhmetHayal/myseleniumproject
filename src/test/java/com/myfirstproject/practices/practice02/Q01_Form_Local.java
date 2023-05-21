package com.myfirstproject.practices.practice02;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.Set;

public class Q01_Form_Local extends TestBase {
    @Test
    public void test() throws InterruptedException {
//        Given go to file:///C:/Users/Tugba/Desktop/BootCamp/MY-HTML-CSS/index.html
    driver.get("file:///C:/Users/Tugba/Desktop/BootCamp/MY-HTML-CSS/index.html");
//        Click on "Click Here For Regisration Form"
    driver.findElement(By.partialLinkText("ion Form")).click();
//        Enter username: John
    Thread.sleep(1000);
    driver.switchTo().alert().sendKeys("John");
    driver.switchTo().alert().accept();
//        Enter password: John.123
    Thread.sleep(1000);
    driver.switchTo().alert().sendKeys("John.123");
    Thread.sleep(1000);
    driver.switchTo().alert().accept();
    Thread.sleep(1000);
    driver.switchTo().alert().accept();
//        Fill the form and click Confirm
    driver.findElement(By.xpath("//input[@placeholder='Firstname Lastname']")).sendKeys("John");
    driver.findElement(By.xpath("//input[@placeholder='username123']")).sendKeys("John");
    driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("John.123");
    driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("John.123");
    driver.findElement(By.xpath("//input[@type='email']")).sendKeys("john@gmail.com");
    driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
    driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
    driver.findElement(By.xpath("(//input[@name='gender'])[1]")).click();
    driver.findElement(By.xpath("//input[@type='date']")).sendKeys("01.01.1990");
    WebElement countryDropdown = driver.findElement(By.xpath("//select"));
    Select select = new Select(countryDropdown);
    select.selectByVisibleText("Japan");
    driver.findElement(By.xpath("//input[@type='color']")).click();
        String pathOfImage = System.getProperty("user.home")+"\\Desktop\\flower.jpeg";
    driver.findElement(By.xpath("//input[@type='file']")).sendKeys(pathOfImage);
    driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("345-543-6676");
    driver.findElement(By.xpath("//textarea")).sendKeys("My name is John. I'm a QA");
    driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
}
