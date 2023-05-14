package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class Day08_Actions3 extends TestBase {
    @Test
    public void scrollUpDown() throws InterruptedException {
//Go to amazon
        driver.get("https://www.amazon.com");
// Scroll the page down
        /*
        Scrolling is a mouse or keyboard action. So we should use actions class.
        Keys.PAGE_DOWN: scroll page down
        Keys.ARROW_DOWN: scroll page down a little bit
        Alternatively we'll use javascript executor.
         */
        Actions actions = new Actions(driver);
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        Thread.sleep(2000);
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        Thread.sleep(2000);
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        Thread.sleep(2000);

        //We can CHAIN these methods
        actions
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .build() // Making the connection built (This is recommended especially after method chains). It can be used anytime before perform().
                .perform(); //execute
        Thread.sleep(2000);

//Scroll the page up
        actions.sendKeys(Keys.PAGE_UP).perform(); // Scrolling page up
        Thread.sleep(2000);
        actions.sendKeys(Keys.ARROW_UP).perform(); // Scrolling page up a little bit
        Thread.sleep(2000);


    }
}
