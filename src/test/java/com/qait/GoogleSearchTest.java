package com.qait;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import sun.awt.www.content.audio.wav;

public class GoogleSearchTest {

    String expectedTitle = "QA InfoTech | Your Software Testing Partner";
    String expectedURL = "https://qainfotech.com/";
    WebDriver driver;
    @BeforeClass 
    public void setUp(){
        driver = new ChromeDriver();
        
        
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.click();
        searchBox.sendKeys("Qa Infotech");
        
        WebElement searchBTN = new WebDriverWait(driver, 2).
        until(ExpectedConditions.visibilityOfElementLocated(By.name("btnK")));
        searchBTN.click();
        
        List<WebElement> allList = driver.findElement(By.className("srg")).findElements(By.tagName("a"));
        allList.get(0).click();
    }
    
    @Test
    public void testTitleOfQait() throws InterruptedException {
        
        
        String actualTitle = driver.getTitle();        
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @Test
    public void testUrlOfQait() {
       
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);

    }

    @AfterClass
    public void tearDown() {
        driver.quit();        
    }
}