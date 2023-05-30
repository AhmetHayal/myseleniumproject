package com.myfirstproject.practices.practicec03;

import com.myfirstproject.utilities.TestBase;
import junit.framework.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Q05_ToDoList extends TestBase {
    /*
  Given
      Go to http://webdriveruniversity.com/To-Do-List/index.html
  When
      Add todos: (Prepare breakfast, Wash the dishes, Take care of baby, Help your kid's homework, Study Selenium, Sleep)
  And
      Strikethrough all todos.
  And
      Delete all todos.
  Then
      Assert that all todos deleted.
   */
    @Test
    public void toDoListTest(){
//      Go to http://webdriveruniversity.com/To-Do-List/index.html
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");

//      Add todos: (Prepare breakfast, Wash the dishes, Take care of baby, Help your kid's homework, Study Selenium, Sleep)
        List<String> toDoList = new ArrayList<>(Arrays.asList("Prepare breakfast", "Wash the dishes", "Take care of baby", "Help your kid's homework", "Study Selenium", "Sleep"));
        System.out.println("toDoList = " + toDoList);
        WebElement toDoInput = driver.findElement(By.xpath("//input[@type='text']"));

        for (String w : toDoList) {
            waitFor(1);
            toDoInput.sendKeys(w + Keys.ENTER);
        }

//      Strikethrough all todos.
        List<WebElement> toDoList2 = driver.findElements(By.xpath("//li"));
        for (WebElement w:toDoList2){
            w.click();
        }

//      Delete all todos.
        List<WebElement> deleteIcons = driver.findElements(By.xpath("//i[@class='fa fa-trash']"));
        for(WebElement w:deleteIcons){
            waitFor(1);
            w.click();
        }
        waitFor(1);

//      Assert that all todos deleted.
        int size = driver.findElements(By.xpath("//li")).size();
        System.out.println("size = " + size);
        assertEquals(0, size);

//        String t=driver.findElement(By.xpath("//ul")).getText();
//        System.out.println("t = " + t);
//        Assert.assertTrue(t.isEmpty());
    }
}
