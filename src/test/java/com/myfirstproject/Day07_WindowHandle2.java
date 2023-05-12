package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;

public class Day07_WindowHandle2 extends TestBase {
    @Test
    public void newTabTest() throws InterruptedException {
//      Amazon title test
        driver.get("https://www.amazon.com");
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        String amazonWindowHandle = driver.getWindowHandle();
        Thread.sleep(5000);

//      Linkedin title test
        driver.switchTo().newWindow(WindowType.TAB); //Create a NEW TAB AND SWITCH TO IT
        driver.get("https://www.linkedin.com");
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));
        String linkedinWindowHandle = driver.getWindowHandle();
        Thread.sleep(5000);

//      Ebay title test
        driver.switchTo().newWindow(WindowType.TAB); //Create a NEW TAB and switch to it
        driver.get("https://www.ebay.com");
        Assert.assertTrue(driver.getTitle().contains("eBay"));
        String ebayWindowHandle = driver.getWindowHandle();
        Thread.sleep(5000);

//      At this point driver is on EBAY, but I want to switch to Amazon or Linkedin
        driver.switchTo().window(amazonWindowHandle);
        System.out.println("TITLE OF AMAZON: "+driver.getTitle());
        Thread.sleep(5000);

        driver.switchTo().window(linkedinWindowHandle);
        System.out.println("TITLE OF LINKEDIN: "+driver.getTitle());
    }
// Copy the method body
// change TAB -> WINDOW
    @Test
    public void newWindowTest() throws InterruptedException {
//      Amazon title test
        driver.get("https://www.amazon.com");
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        String amazonWindowHandle = driver.getWindowHandle();
        Thread.sleep(5000);

//      Linkedin title test
        driver.switchTo().newWindow(WindowType.WINDOW); //Create a NEW WINDOW AND SWITCH TO IT
        driver.get("https://www.linkedin.com");
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));
        String linkedinWindowHandle = driver.getWindowHandle();
        Thread.sleep(5000);

//      Ebay title test
        driver.switchTo().newWindow(WindowType.WINDOW); //Create a NEW WINDOW and switch to it
        driver.get("https://www.ebay.com");
        Assert.assertTrue(driver.getTitle().contains("eBay"));
        String ebayWindowHandle = driver.getWindowHandle();
        Thread.sleep(5000);

//      At this point driver is on EBAY, but I want to switch to Amazon or Linkedin
        driver.switchTo().window(amazonWindowHandle);
        System.out.println("TITLE OF AMAZON: "+driver.getTitle());
        Thread.sleep(5000);

        driver.switchTo().window(linkedinWindowHandle);
        System.out.println("TITLE OF LINKEDIN: "+driver.getTitle());

    }
}
