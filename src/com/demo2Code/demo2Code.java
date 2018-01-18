package com.demo2Code;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.LocalDate;

import javax.swing.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class demo2Code {

    @Test
    public void demo2Code() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.navigate().to("https://editor.datatables.net/examples/inline-editing/simple");

        WebElement table = driver.findElement(By.cssSelector("table[id='example']"));
        List<WebElement> rows = table.findElements(By.tagName("tr")); //list of elements
        List<WebElement> data = rows.get(3).findElements(By.tagName("td"));

        Actions action = new Actions(driver);

        //perform actions of each individual item
        for (WebElement outcome : data) {

//         outcome.click();
//         Thread.sleep(3000);
//         outcome.sendKeys("abc");

            action.click(outcome).build().perform();
            Thread.sleep(3000);
            action.sendKeys(outcome, "abc");
            System.out.println(outcome.getText());
        }

    }

    @Test
    public void iframeTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.navigate().to("http://sahitest.com/demo/iframesTest.htm");

        driver.manage().window().maximize();

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[value='Click me']")).click();
        Thread.sleep(2000);

        driver.switchTo().frame(0);

        driver.findElement(By.linkText("Alert Test")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[name='b1']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        Thread.sleep(2000);
        driver.findElement(By.linkText("Back")).click();
        Thread.sleep(2000);

        //////

        driver.findElement(By.linkText("Confirm Page")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[name='b1']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        String ActualOk =  driver.findElement(By.cssSelector("input[name='t1']")).getAttribute("value");
        String ExpectedOk = "oked";
        Boolean isPresent = ActualOk.matches(ExpectedOk);
        Assert.assertTrue("No message displayed", isPresent);

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[name='b1']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);

        String ActualCancel =  driver.findElement(By.cssSelector("input[name='t1']")).getAttribute("value");
        String ExpectedCancel = "canceled";
        Boolean isPresent1 = ActualCancel.matches(ExpectedCancel);
        Assert.assertTrue("No message displayed", isPresent1);

        /////

        Thread.sleep(2000);
        driver.findElement(By.linkText("Back")).click();
        Thread.sleep(2000);

        driver.findElement(By.linkText("File Upload Test")).click();
        Thread.sleep(2000);
        WebElement fileInput = driver.findElement(By.cssSelector("input[id='file']"));
        String path = "C:/Users/VD-Shireen/Desktop/hello.png";
        fileInput.sendKeys(path);
        driver.findElement(By.cssSelector("input[value='Submit Single']")).click();

        Thread.sleep(12000);

        String fileName =  driver.findElement(By.cssSelector("span[id='file']")).getText();
        Boolean isPresent2 = fileName.contentEquals(path.substring(28));
        Assert.assertTrue("Link not found", isPresent2);

    }


    @Test
    public void datePicker() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.navigate().to("https://jqueryui.com/datepicker/");

        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd");
        LocalDate localDate = LocalDate.now();  //today's date
        int date = localDate.getDayOfMonth();

        driver.switchTo().frame(0);

        driver.findElement(By.id("datepicker")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("span[class='ui-icon ui-icon-circle-triangle-e']")).click();
        Thread.sleep(1000);

        WebElement table = driver.findElement(By.cssSelector("table[class='ui-datepicker-calendar']"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        List<WebElement> data = null;

        Actions action = new Actions(driver);

        int row = 1;
        Boolean out = false;

        while(row < rows.size()) {
            for (int i = 0; i <= rows.size(); i++) {
                data = rows.get(row).findElements(By.tagName("td"));
                if( data.get(i).getText() .equals(Integer.toString(date) ) )
                {
                    action.click(data.get(i)).build().perform();
                    out = true;
                    break;
                }
            }
            if(out) break;
            else row++;
        }

      //  driver.findElement(By.linkText(Integer.toString(date))).click();


    }
}



