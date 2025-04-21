package com.revature;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class Level1 {

    WebDriver driver;


    @FindBy(xpath = "/html/body/h2")
    WebElement header;

    @FindBy(id = "randomString")
    WebElement randomString;

    @FindBy(id = "nameInput")
    WebElement nameInput;

    @FindBy(xpath = "/html/body/form/button")
    WebElement submitButton;


    public Level1(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void submitRandomName(){
        String name = randomString.getText();
        nameInput.sendKeys(name);
        submitButton.click();
    }

    public void takeSS() throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("src/main/resources/screenshots/Level-1.png"));
    }

    public void openLevel1(){
        driver.get("C:\\Users\\Josh\\Desktop\\inFormed-Josh\\Important Resources\\InFormed\\level-1.html");
    }

}



