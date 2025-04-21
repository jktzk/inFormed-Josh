package com.revature;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class Level5 {

    WebDriver driver;


    @FindBy(xpath = "/html/body/form/input")
    WebElement inputfield;

    @FindBy(xpath = "/html/body/form/button[2]")
    WebElement submit;

    @FindBy(xpath = "/html/body/form/button[1]")
    WebElement modal;


    @FindBy(xpath = "/html/body/form/dialog/button")
    WebElement modalClose;

    public Level5(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openLevel5(){
        driver.get("C:\\Users\\Josh\\Desktop\\inFormed-Josh\\Important Resources\\InFormed\\level-5.html");
    }

    public void inputText(){
        for(int i = 0;i<101;i++){
            inputfield.sendKeys("a");
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();
        }

    }

    public void clickModal(){
        modal.click();
    }

    public void clickSubmit(){
        submit.click();
    }

    public void clickModalClose(){
        modalClose.click();
    }

    public void takeSS() throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("src/main/resources/screenshots/Level-5.png"));
    }

    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            Level5 Level5 = new Level5(driver);
            Level5.openLevel5();
            Level5.inputText();
            Level5.clickModal();
            Level5.takeSS();
            Level5.clickModalClose();
            Level5.clickSubmit();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
