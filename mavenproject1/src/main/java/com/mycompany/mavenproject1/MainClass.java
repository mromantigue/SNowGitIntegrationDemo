/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
 
import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 *
 * @author mromantigue
 */
public class MainClass {
    
    public static void main(String[] args)
 
    {

    //System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Jenkins\\workspace\\chromedriver.exe");
    WebDriverManager.getInstance(CHROME).setup();
    WebDriver driver = new ChromeDriver();

    driver.navigate().to("https://dev60689.service-now.com/login.do");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    String appTitle = driver.getTitle();

    System.out.println("Application title is : "+appTitle);
    
    new WebDriverWait(driver, 30).until(new ExpectedCondition<Boolean>() {

        public Boolean apply(WebDriver arg0) {
            WebElement username = driver.findElement(By.id("user_name"));

            return username.isDisplayed();
        }
    });
    WebElement username = driver.findElement(By.id("user_name"));
    WebElement password = driver.findElement(By.id("user_password"));
    WebElement loginButton = driver.findElement(By.id("sysverb_login"));

    System.out.println("Logging into : "+appTitle);
    username.sendKeys("admin");
    password.sendKeys("uySoU5s7OVzK");
    loginButton.click();
    
    driver.navigate().to(driver.getCurrentUrl());
    new WebDriverWait(driver, 30).until(new ExpectedCondition<Boolean>() {

        public Boolean apply(WebDriver arg0) {
            WebElement filter = driver.findElement(By.id("filter"));

            return filter.isDisplayed();
        }
    });
    
    WebElement filter = driver.findElement(By.id("filter"));
    System.out.println("Navigating to new catalog items...");
    driver.findElement(By.id("favorites_tab")).click();
    new WebDriverWait(driver, 30).until(new ExpectedCondition<Boolean>() {

        public Boolean apply(WebDriver arg0) {
            WebElement filter = driver.findElement(By.cssSelector(".sn-widget:nth-child(3) .sn-widget-list-item:nth-child(1) > .sn-widget-list-item .sn-widget-list-title"));

            return filter.isDisplayed();
        }
    });
    driver.findElement(By.cssSelector(".sn-widget:nth-child(3) .sn-widget-list-item:nth-child(1) > .sn-widget-list-item .sn-widget-list-title")).click();
    driver.switchTo().frame(0);
    new WebDriverWait(driver, 30).until(new ExpectedCondition<Boolean>() {

        public Boolean apply(WebDriver arg0) {
            WebElement filter = driver.findElement(By.linkText("New Standard Laptop Request"));

            return filter.isDisplayed();
        }
    });
    driver.findElement(By.linkText("New Standard Laptop Request")).click();
    new WebDriverWait(driver, 30).until(new ExpectedCondition<Boolean>() {

        public Boolean apply(WebDriver arg0) {
            WebElement filter = driver.findElement(By.id("try_it_catalog"));

            return filter.isDisplayed();
        }
    });
    driver.findElement(By.id("try_it_catalog")).click();
    new WebDriverWait(driver, 30).until(new ExpectedCondition<Boolean>() {

        public Boolean apply(WebDriver arg0) {
            WebElement filter = driver.findElement(By.id("IO:f5acbe77db3300108d22f36f299619be"));

            return filter.isDisplayed();
        }
    });
    driver.findElement(By.id("IO:f5acbe77db3300108d22f36f299619be")).sendKeys("Sample Text");
    driver.findElement(By.id("IO:bdacbe77db3300108d22f36f299619ca")).click();
    driver.findElement(By.id("IO:bdacbe77db3300108d22f36f299619ca")).sendKeys("Sample Text 2");
    driver.findElement(By.id("IO:3dacbe77db3300108d22f36f299619c2")).click();
    driver.findElement(By.id("IO:3dacbe77db3300108d22f36f299619c2")).sendKeys("Sample Text 3");
    driver.findElement(By.id("IO:bdacbe77db3300108d22f36f299619c6")).click();
    driver.findElement(By.id("IO:bdacbe77db3300108d22f36f299619c6")).sendKeys("Sample Text 4");
    driver.findElement(By.cssSelector("#element\\.IO\\3A bdacbe77db3300108d22f36f299619ca > .iotd")).click();
    driver.findElement(By.id("oi_order_now_button")).click();
    driver.switchTo().defaultContent();
    new WebDriverWait(driver, 30).until(new ExpectedCondition<Boolean>() {

        public Boolean apply(WebDriver arg0) {
            WebElement filter = driver.findElement(By.id("favorites_tab"));

            return filter.isDisplayed();
        }
    });
    driver.findElement(By.id("favorites_tab")).click();
    new WebDriverWait(driver, 30).until(new ExpectedCondition<Boolean>() {

        public Boolean apply(WebDriver arg0) {
            WebElement filter = driver.findElement(By.cssSelector(".sn-widget:nth-child(3) .sn-widget-list-item:nth-child(1) > .sn-widget-list-item .sn-widget-list-title"));

            return filter.isDisplayed();
        }
    });
    driver.findElement(By.cssSelector(".sn-widget:nth-child(3) .sn-widget-list-item:nth-child(1) > .sn-widget-list-item .sn-widget-list-title")).click();
    driver.switchTo().frame(0);
    new WebDriverWait(driver, 30).until(new ExpectedCondition<Boolean>() {

        public Boolean apply(WebDriver arg0) {
            WebElement filter = driver.findElement(By.linkText("New Service Category Request"));

            return filter.isDisplayed();
        }
    });
    driver.findElement(By.linkText("New Service Category Request")).click();
    new WebDriverWait(driver, 30).until(new ExpectedCondition<Boolean>() {

        public Boolean apply(WebDriver arg0) {
            WebElement filter = driver.findElement(By.id("try_it_catalog"));

            return filter.isDisplayed();
        }
    });
    driver.findElement(By.id("try_it_catalog")).click();
    new WebDriverWait(driver, 30).until(new ExpectedCondition<Boolean>() {

        public Boolean apply(WebDriver arg0) {
            WebElement filter = driver.findElement(By.id("IO:e07cf677db3300108d22f36f29961940"));

            return filter.isDisplayed();
        }
    });
    driver.findElement(By.id("IO:e07cf677db3300108d22f36f29961940")).sendKeys("Sample Text");
    {
      WebElement element = driver.findElement(By.id("IO:647cf677db3300108d22f36f29961992"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    {
      WebElement element = driver.findElement(By.id("IO:f47cf677db3300108d22f36f29961997"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    driver.findElement(By.cssSelector("table:nth-child(2) > tbody tbody")).click();
    driver.findElement(By.id("IO:f47cf677db3300108d22f36f29961997")).click();
    driver.findElement(By.id("IO:f47cf677db3300108d22f36f29961997")).sendKeys("Sample Text 2");
    driver.findElement(By.id("IO:607cf677db3300108d22f36f2996194a")).click();
    driver.findElement(By.id("IO:607cf677db3300108d22f36f2996194a")).sendKeys("Sample Text 3");
    driver.findElement(By.id("IO:e07cf677db3300108d22f36f2996198d")).click();
    driver.findElement(By.id("IO:e07cf677db3300108d22f36f2996198d")).sendKeys("Sample Text 4");
    driver.findElement(By.id("IO:e07cf677db3300108d22f36f29961938")).click();
    driver.findElement(By.id("IO:e07cf677db3300108d22f36f29961938")).sendKeys("Sample Text 5");
    driver.findElement(By.cssSelector("#element\\.IO\\3A f47cf677db3300108d22f36f29961997 .row")).click();
    driver.findElement(By.id("submit_button")).click();
    driver.switchTo().defaultContent();
    new WebDriverWait(driver, 30).until(new ExpectedCondition<Boolean>() {

        public Boolean apply(WebDriver arg0) {
            WebElement filter = driver.findElement(By.cssSelector("#user_info_dropdown > div"));

            return filter.isDisplayed();
        }
    });
    driver.findElement(By.cssSelector("#user_info_dropdown > div")).click();
    driver.findElement(By.linkText("Logout")).click();

    driver.quit();

    }
    
}
