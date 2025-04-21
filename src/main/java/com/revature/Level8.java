package com.revature;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class Level8 {


    @FindBy(xpath = "/html/body/input")
    WebElement fileInput;

    @FindBy(xpath = "/html/body/button")
    WebElement submitButton;


    WebDriver driver;

    public Level8(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openLevel8 (){
        driver.get("C:\\Users\\Josh\\Desktop\\inFormed-Josh\\Important Resources\\InFormed\\level-8.html");
        System.out.println(driver.getWindowHandle());
    }

    public void uploadFile(){
        fileInput.sendKeys("C:\\Users\\Josh\\Desktop\\inFormed-Josh\\src\\main\\resources\\auxiliaryFiles\\letsGoGators");
    }

    public void clickSubmit(){
        submitButton.click();
    }

    public void takeSS() throws IOException {
        java.io.File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("src/main/resources/screenshots/Level-8.png"));
    }


    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            Level8 Level8 = new Level8(driver);
            Level8.openLevel8();
            Level8.uploadFile();
            Level8.takeSS();
            Level8.clickSubmit();


        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
