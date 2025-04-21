package com.revature;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class Level3 {
    WebDriver driver;


    @FindBy(xpath = "/html/body/form/button")
    WebElement submit;
    @FindBy(xpath = "/html/body/form/input[1]")
    WebElement input1;
    @FindBy(xpath = "/html/body/form/input[2]")
    WebElement input2;
    @FindBy(xpath = "/html/body/form/input[3]")
    WebElement input3;


    public Level3(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openLevel3(){
      driver.get("C:\\Users\\Josh\\Desktop\\inFormed-Josh\\Important Resources\\InFormed\\level-3.html");
    }

    public void submitDate1(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(input1));
        input1.sendKeys("abc");
    }
    public void submitDate2(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(input2));
        input2.sendKeys("abc");
    }
    public void submitDate3(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(input3));
        input3.sendKeys("abc");

    }

    public void click(){
        submit.click();
    }

    public void takeSS() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(input3));
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("src/main/resources/screenshots/Level-3.png"));
    }


    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            Level3 Level3 = new Level3(driver);
            Level3.openLevel3();
            Level3.submitDate1();
            Level3.submitDate2();
            Level3.submitDate3();
            Level3.click();
            Level3.takeSS();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

}
