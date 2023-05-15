package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

public class Dnm extends TestBase {
    @Test
    public void gztdvr(){
        driver.get("https://www.gazeteduvar.com.tr");
        driver.findElement(By.linkText("Seçim 2023")).click();
    }
}
