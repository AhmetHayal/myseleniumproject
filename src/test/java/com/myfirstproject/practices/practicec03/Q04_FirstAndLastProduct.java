package com.myfirstproject.practices.practicec03;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Q04_FirstAndLastProduct extends TestBase {
    /*
    Given
        Go to https://www.saucedemo.com/
    When
        Enter the username as "standard_user"
    And
        Enter the password as "secret_sauce"
    And
        Click on login button
    And
        Order products by "Price (low to high)"
    Then
        Assert that last product costs $49.99, first product costs $7.99
     */
    @Test
    public void Test(){
//        Go to https://www.saucedemo.com/
        driver.get("https://www.saucedemo.com/");

//        Enter the username as "standard_user"
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

//        Enter the password as "secret_sauce"
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

//        Click on login button
        driver.findElement(By.id("login-button")).click();

//        Order products by "Price (low to high)"
        WebElement dropDown = driver.findElement(By.xpath("//select[@data-test='product_sort_container']"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Price (low to high)");

//        Assert that last product costs $49.99, first product costs $7.99
        int numOfProducts = driver.findElements(By.xpath("//div[@class='inventory_item_price']")).size();

        String priceOfFirstProduct = driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[1]")).getText();
        System.out.println("priceOfFirstProduct = " + priceOfFirstProduct);

        String priceOfLastProduct = driver.findElement(By.xpath("(//div[@class='inventory_item_price'])["+numOfProducts+"]")).getText();
        System.out.println("priceOfLastProduct = " + priceOfLastProduct);

        Assert.assertTrue(priceOfLastProduct.equals("$49.99"));
        Assert.assertTrue(priceOfFirstProduct.equals("$7.99"));

    }
}
