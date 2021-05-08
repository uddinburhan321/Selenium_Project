package com.peoplentech.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverLaunch {
    public static void main(String[] args) throws InterruptedException {

        //setup the property
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        //created object of chrome driver
        WebDriver driver = new ChromeDriver();

        //open the browser
        driver.get("https://www.google.com");

        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("java books");

        Thread.sleep(5000);

        driver.findElement(By.xpath("//input[@aria-label='Google Search']")).click();

        //wait
        Thread.sleep(5000);

        //close the browser
        driver.quit();
    }
}
