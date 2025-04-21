package com.revature;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Level10 {

    WebDriver driver;

    @FindBy(xpath = "/html/body/input")
    WebElement fileInput;

    @FindBy(xpath = "/html/body/button")
    WebElement reviewButton;

    public Level10(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String openLevel10 (){
        driver.get("C:\\Users\\Josh\\Desktop\\inFormed-Josh\\Important Resources\\InFormed\\level-10.html");
        System.out.println(driver.getWindowHandle());
        return driver.getWindowHandle();
    }


    public void uploadFile(){
        fileInput.sendKeys("C:\\Users\\Josh\\Desktop\\inFormed-Josh\\src\\main\\resources\\screenshots\\Level-10.png");
    }

    public void clickSubmit(){
        reviewButton.click();
    }

    public void takeSS() throws IOException {
        java.io.File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("src/main/resources/screenshots/Level-10.png"));
    }


    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            Level10 Level10 = new Level10(driver);
            Level10.openLevel10();
            Level10.takeSS();
            Level10.uploadFile();
            Level10.clickSubmit();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
            Level10.takeSS();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }       }
}
