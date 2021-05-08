package com.peoplentech.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DriverLaunch1 {

    private static WebDriver driver;

    public static void setUpBrowser( String browser, String url) {

        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            driver = new ChromeDriver(options);
        }else{
            System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.get(url);
    }

    public static void waitFor(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickOnLinkedTest(String lnkTxt){
        driver.findElement(By.id(lnkTxt));
    }

    public void findElementByXpath(String xpath){
        driver.findElement(By.xpath(xpath));
    }

    public void clickElementByXpath(String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }

    public void typeOnXpath(String xpath, String data){
        driver.findElement(By.xpath(xpath)).sendKeys(data);
    }


    @Test
    public void anyMethod() throws InterruptedException {

        setUpBrowser("chrome","ebay");
        clickOnLinkedTest("register");
        closeBrowser();

    }

    @Test
    public void anyMethod1() throws InterruptedException {

        setUpBrowser("gecko","ebay");
        driver.findElement(By.linkText("register")).click();
        driver.navigate().back();
        closeBrowser();

    }

    public static void closeBrowser() throws InterruptedException {
        waitFor(3);
        driver.quit();
    }
}
