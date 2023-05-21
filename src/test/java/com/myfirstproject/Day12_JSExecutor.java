package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class Day12_JSExecutor extends TestBase {

    @Test
    public void scrollIntoViewTest() throws IOException {
//      Locating footer element on amazon.com
        driver.get("https://www.amazon.com/");
        WebElement footer = driver.findElement(By.xpath("//div[@id='navFooter']//tbody"));
//      scroll into that element
        scrollIntoViewJS(footer);
//      Assert if that element exists on the page
        Assert.assertTrue(footer.isDisplayed());
//      take a screenshot of the page
        takeScreenshotOfTheEntirePage();
//      locate searchBox and scroll into that element, assert if that element exists and take a screenshot
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        scrollIntoViewJS(searchBox);
        Assert.assertTrue(searchBox.isDisplayed());
        takeScreenshotOfTheEntirePage();
    }

    @Test
    public void scrollAllTheWayDownUpTest() throws IOException, InterruptedException {
        driver.get("https://www.amazon.com/");
//  scroll all the way down and  take a screenshot of the page
        scrollAllTheWayDownJS();
        takeScreenshotOfTheEntirePage();
        Thread.sleep(3000);
        scrollAllTheWayUpJS();
        takeScreenshotOfTheEntirePage();
    }

    @Test
    public void clickByJSTest() throws InterruptedException, IOException {
//  search porcelain tea set on amazon
        driver.get("https://www.amazon.com/");
//  locate search box
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
//  type porcelain tea set
        searchBox.sendKeys("porcelain tea set");
        Thread.sleep(2000);
        takeScreenshotOfTheEntirePage();
//  locate search button and click on it by JS Executor
        WebElement searchIcon = driver.findElement(By.id("nav-search-submit-button"));
        clickByJS(searchIcon); // JS CLICK
        takeScreenshotOfTheEntirePage();
    }
}
