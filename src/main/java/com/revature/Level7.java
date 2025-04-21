package com.revature;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class Level7 {
    WebDriver driver;

    @FindBy(xpath = "/html/body/button[1]")
    WebElement sButton;
    @FindBy(xpath = "/html/body/button[2]")
    WebElement lButton;

    @FindBy(xpath ="/html/body/button[3]")
    WebElement submitButton;


    public Level7(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String openLevel7 (){
        driver.get("C:\\Users\\Josh\\Desktop\\inFormed-Josh\\Important Resources\\InFormed\\level-7.html");
        System.out.println(driver.getWindowHandle());
        return driver.getWindowHandle();
    }

    public void resizeSmaller(){
        Dimension dimension = new Dimension(599, 599);
        driver.manage().window().setSize(dimension);
        sButton.click();
    }

    public void resizeBigger(){
        Dimension dimension = new Dimension(1601, 1601);
        driver.manage().window().setSize(dimension);
        lButton.click();
    }

    public void submit(){
        submitButton.click();
    }





    public void takeSS() throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("src/main/resources/screenshots/Level-7.png"));
    }


    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            Level7 Level7 = new Level7(driver);
            Level7.openLevel7();
            Level7.resizeSmaller();
            Level7.resizeBigger();
            Level7.takeSS();
            Level7.submit();
            driver.switchTo().alert().accept();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
    
}
