package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Day11_WebTables extends TestBase {
//  https://the-internet.herokuapp.com/tables

    @Test
    public void printTable(){
//  Task 1: Print the entire table
        driver.get("https://the-internet.herokuapp.com/tables");
        extentTest.pass("*****PRINT ENTIRE TABLE*****");
        String entireTable = driver.findElement(By.xpath("//table[@id='table1']")).getText();
        System.out.println(entireTable);

//      ALTERNATIVELY
        List<WebElement> elements = driver.findElements(By.xpath("//table[@id='table1']//td"));

        for(WebElement eachData:elements){
            System.out.println(eachData.getText());
            extentTest.pass(eachData.getText());
        }
//      GET SPECIFIC INDEXED ELEMENTS
        System.out.println("6TH DATA IN THE TABLE =>>> "+elements.get(5).getText());
    }
    @Test
    public void printAllRows(){
//  Task 2: Print all rows
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        int rowNum=1;
        for (WebElement eachRow : allRows){
            System.out.println(rowNum+" : "+eachRow.getText());
            rowNum++;
        }
        System.out.println("2ND ROW DATA: "+allRows.get(1).getText());
//  Task 3: Print last data row only
        System.out.println("LAST ROW DATA: "+allRows.get(allRows.size()-1).getText());
    }
    @Test
    public void printColumns(){
//  Task 4: Print column 5 data in the table body
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> col5data = driver.findElements(By.xpath("//table[@id='table1']//td[5]"));
        int colNum = 1;
        for (WebElement eachData : col5data){
            System.out.println(colNum +" : "+eachData.getText());
            extentTest.pass(eachData.getText());
            colNum++;
        }
    }
    public static void printDataMethod(int rowNum, int columnNum){
//  Task 5: Write a method that accepts 2 parameters
//  Parameter 1 = row number
//  Parameter 2 = column number
//  printData(2,3); => prints data in the 2nd row and 3rd column
        driver.get("https://the-internet.herokuapp.com/tables");
        String target = driver.findElement(By.xpath("//table[@id='table1']//tr["+rowNum+"]//td["+columnNum+"]")).getText();
        System.out.println("target = " + target);
    }
    @Test
    public void printDataTest(){
        printDataMethod(3,1);
    }

}
