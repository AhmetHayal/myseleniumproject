package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class day09_Authentication extends TestBase {
    @Test
    public void authTest(){
            /*
        username: admin
        password:admin
        url     :the-internet.herokuapp.com/basic_auth
         */
//        driver.get("http://the-internet.herokuapp.com/basic_auth");
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");

// Assert if login is successful
        String actualLoginText = driver.findElement(By.xpath("//div[@id='content']//p")).getText();
        Assert.assertTrue(actualLoginText.contains("Congratulations!"));
    }
}
