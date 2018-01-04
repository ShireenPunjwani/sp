package com.company;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoCodeClass {

    @Test
    public void firstClass(){

        //System.setProperty("webdriver.chrome.driver", "driver/chromedriver"); For Mac
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");

        ChromeDriver driver = new ChromeDriver(); //Initliazation
        driver.navigate().to("http://www.practiceselenium.com/practice-form.html"); //Navigation

        driver.findElement(By.name("firstname")).sendKeys("my"); //entering data
        driver.findElement(By.name("lastname")).sendKeys("user");

        driver.findElement(By.id("sex-1")).click();

        driver.findElement(By.id("exp-2")).click();

        driver.findElement(By.id("datepicker")).sendKeys("1/1/2017");

        driver.findElement(By.id("tea2")).click();

        driver.findElement(By.id("tool-1")).click(); //performing action using click

        Select dropdown = new Select(driver.findElement(By.id("continents")));
        dropdown.selectByIndex(2);

        Select dropdown2 = new Select(driver.findElement(By.id("selenium_commands")));
        dropdown2.selectByIndex(2);

        driver.findElement(By.id("submit")).click();

//        Boolean isThere = driver.findElementByClassName("editor_sidebarmore").isDisplayed();
//        Assert.assertTrue("Link not found", isThere);

        Boolean isPresent =  driver.findElement(By.linkText("seleniumframework.com")).isDisplayed();
        Assert.assertTrue("Link not found",isPresent);

        String Url = driver.getCurrentUrl();
        Assert.assertEquals(Url, "http://www.practiceselenium.com/welcome.html?firstname=my&lastname=user&sex=Female&exp=3&RedTea=Red+Tea&tool=Harmless+Addiction&continents=Asia&selenium_commands=Switch+Commands&submit=" );
    }
}
