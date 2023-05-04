package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumClass {
    public static void main(String[] args) {
//  This is one way to create an automation script
//  We will not use main method later on.

// WINDOWS      ".exe" is required on Windows.      "./" might also be required for both windows and mac.
    System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");//Later we will not use this method.

// MAC
//  System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");//Later we will not use this method.

//  create driver
        WebDriver driver = new ChromeDriver();

//  navigate to website
        driver.get("https://www.techproeducation.com");

    }
}
