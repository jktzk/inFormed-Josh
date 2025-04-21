package com.revature;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Level4 {
    WebDriver driver;




    @FindBy(xpath = "/html/body/form/input")
    WebElement inputfield;

    @FindBy(xpath = "/html/body/form/button")
    WebElement button;
    public Level4(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openLevel4(){
        driver.get("C:\\Users\\Josh\\Desktop\\inFormed-Josh\\Important Resources\\InFormed\\level-4.html");
    }

    public void inputText(){
        for(int i = 0;i<101;i++){
            inputfield.sendKeys("a");
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();
        }

    }

    public void clickSubmit(){
        button.click();
    }

    public void takeSS() throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("src/main/resources/screenshots/Level-4.png"));
    }


    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            Level4 Level4 = new Level4(driver);
            Level4.openLevel4();
            Level4.inputText();
            Level4.clickSubmit();
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();
            Level4.takeSS();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

}