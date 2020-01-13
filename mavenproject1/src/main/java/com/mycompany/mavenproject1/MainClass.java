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

    driver.navigate().to("https://dev70481.service-now.com/login.do");
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
    password.sendKeys("muZk9PZOl1kN");
    loginButton.click();
    
    driver.navigate().to(driver.getCurrentUrl());
    new WebDriverWait(driver, 30).until(new ExpectedCondition<Boolean>() {

        public Boolean apply(WebDriver arg0) {
            WebElement filter = driver.findElement(By.id("filter"));

            return filter.isDisplayed();
        }
    });
    
    WebElement filter = driver.findElement(By.id("filter"));
    System.out.println("Navigating to Maintain Items module...");
    filter.sendKeys("Maintain Items");
    filter.sendKeys(Keys.ENTER);
    System.out.println("Checking if pages in this module are reachable");
    driver.navigate().to("https://dev86178.service-now.com/nav_to.do?uri=%2Fsc_cat_item_producer.do%3Fsys_id%3D3a25637b47701100ba13a5554ee490a0%26sysparm_record_target%3Dsc_cat_item%26sysparm_record_row%3D1%26sysparm_record_rows%3D143%26sysparm_record_list%3Dtype%2521%253Dbundle%255Esys_class_name%2521%253Dsc_cat_item_guide%255Etype%2521%253Dpackage%255Esys_class_name%2521%253Dsc_cat_item_content%255Esc_catalogs%253DNULL%255EORsc_catalogsDOES%2BNOT%2BCONTAIN0b22fd2ad7021100b9a5c7400e610319%255EORDERBYorder");
    
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.navigate().to("https://dev86178.service-now.com/nav_to.do?uri=%2Fsc_cat_item_producer.do%3Fsys_id%3D3a25637b47701100ba13a5554ee490a0%26sysparm_record_target%3Dsc_cat_item%26sysparm_record_row%3D1%26sysparm_record_rows%3D143%26sysparm_record_list%3Dtype%2521%253Dbundle%255Esys_class_name%2521%253Dsc_cat_item_guide%255Etype%2521%253Dpackage%255Esys_class_name%2521%253Dsc_cat_item_content%255Esc_catalogs%253DNULL%255EORsc_catalogsDOES%2BNOT%2BCONTAIN0b22fd2ad7021100b9a5c7400e610319%255EORDERBYorder");

    driver.quit();

    }
    
}
