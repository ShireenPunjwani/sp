package com.company;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoCodeClass {

    @Test
    public void firstClass(){

        //System.setProperty("webdriver.chrome.driver", "driver/chromedriver"); For Mac
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");

        ChromeDriver driver = new ChromeDriver(); //Initliazation
        driver.navigate().to("http://www.practiceselenium.com/practice-form.html"); //Navigation

        String fname = "my";
        driver.findElement(By.name("firstname")).sendKeys(fname);

        //driver.findElement(By.name("firstname")).sendKeys("my"); //entering data
        //String fname = driver.findElement(By.name("firstname")).getText();
        //System.out.println("firstname : " + fname);

        String lname = "user";
        driver.findElement(By.name("lastname")).sendKeys(lname);

        WebElement gender = driver.findElement(By.id("sex-1"));
        gender.click();
        String genderValue = gender.getAttribute("value");

        WebElement exp = driver.findElement(By.id("exp-3"));
        exp.click();
        String expValue = exp.getAttribute("value");

        String date = "1/1/2017";
        driver.findElement(By.id("datepicker")).sendKeys(date);

        WebElement tea = driver.findElement(By.id("tea1"));
        tea.click();
        String teaV = tea.getAttribute("value");
        String teaValue = teaV.replace(" ", "");
        String teaValueSelected = teaV.replace(' ' , '+');

        WebElement tool = driver.findElement(By.id("tool-2"));
        tool.click(); //performing action using click
        String toolValue = tool.getAttribute("value");
        String toolValueSelected = toolValue.replace(' ' , '+');

        Select dropdown = new Select(driver.findElement(By.id("continents")));
        dropdown.selectByIndex(1);
        String contValue = dropdown.getFirstSelectedOption().getText();

        Select dropdown2 = new Select(driver.findElement(By.id("selenium_commands")));
        dropdown2.selectByIndex(3);
        String selComValue = dropdown2.getFirstSelectedOption().getText();
        String selComValueSelected = selComValue.replace(' ', '+');

        driver.findElement(By.id("submit")).click();

        //for "more"
//        Boolean isThere = driver.findElementByClassName("editor_sidebarmore").isDisplayed();
//        Assert.assertTrue("Link not found", isThere);

        Boolean isPresent =  driver.findElement(By.linkText("seleniumframework.com")).isDisplayed();
        Assert.assertTrue("Link not found",isPresent);

        String Url = driver.getCurrentUrl();
        String ActualUrl = "http://www.practiceselenium.com/welcome.html?firstname="+fname+"&lastname="+lname+"&sex="+genderValue+"&exp="+expValue+"&"+teaValue+"="+teaValueSelected+"&tool=" +toolValueSelected +"&continents=" + contValue + "&selenium_commands="+selComValueSelected+"&submit=";
        Assert.assertEquals(Url, ActualUrl);
    }
}
