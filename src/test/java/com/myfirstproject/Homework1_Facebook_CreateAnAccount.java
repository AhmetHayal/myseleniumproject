package com.myfirstproject;

import com.github.javafaker.Faker;
import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.nio.file.WatchEvent;

public class Homework1_Facebook_CreateAnAccount extends TestBase {
    Faker faker = new Faker();
    @Test
    public void facebookCreateAnAccountTest(){
        driver.get("https://www.facebook.com/signup");
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(faker.name().firstName());
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(faker.name().lastName());
        driver.findElement(By.name("reg_email__")).sendKeys("dara.smitham@yahoo.com");
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("dara.smitham@yahoo.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(faker.internet().password());
        WebElement dayDropdown = driver.findElement(By.id("day"));
        Select dayOptions = new Select(dayDropdown);
        dayOptions.selectByValue("7");
        WebElement monthDropdown = driver.findElement(By.id("month"));
        Select monthOptions = new Select(monthDropdown);
        monthOptions.selectByIndex(11);
        WebElement yearDropdown = driver.findElement(By.id("year"));
        Select yearOptions = new Select(yearDropdown);
        yearOptions.selectByValue("1990");
        driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
        driver.findElement(By.xpath("//button[@name='websubmit']")).click();

    }
}
