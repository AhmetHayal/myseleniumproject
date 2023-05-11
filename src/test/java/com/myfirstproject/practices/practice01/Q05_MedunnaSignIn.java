package com.myfirstproject.practices.practice01;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class Q05_MedunnaSignIn extends TestBase {
    @Test
    public void medunnaSignInTest(){
        //Go to https://www.medunna.com/
        driver.get("https://www.medunna.com/");

        // Click on human sign
        driver.findElement(By.id("account-menu")).click();

        // Click on "sign in" option
        driver.findElement(By.id("login-item")).click();

        // Enter "mark_twain" username
        driver.findElement(By.name("username")).sendKeys("mark_twain");

        // Enter "Mark.123" password
        driver.findElement(By.name("password")).sendKeys("Mark.123");

        // Click on "Remember me"
        driver.findElement(By.id("rememberMe")).click();

        //Click on sign in
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Assert that you signed in
        String loginName = driver.findElement(By.xpath("//span[.='Mark Twain']")).getText();
        assertEquals("Mark Twain", loginName);
    }
}
