package com.revature;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.logging.Level;

public class Level6 {
    WebDriver driver;

    @FindBy(xpath = "/html/body/form/h5[1]/a")
    WebElement link1;

    @FindBy(xpath = "/html/body/form/h5[2]/a")
    WebElement link2;

    @FindBy(xpath = "/html/body/form/button")
    WebElement submitButton;

    @FindBy(xpath = "/html/body/button")
    WebElement gateSelector;



    public Level6(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String openLevel6 (){
        driver.get("C:\\Users\\Josh\\Desktop\\inFormed-Josh\\Important Resources\\InFormed\\level-6a.html");
        System.out.println(driver.getWindowHandle());
        return driver.getWindowHandle();
    }

    public void newTab(){
        driver.switchTo().newWindow(WindowType.TAB);
    }

    public void clickGate1(){
        link1.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        gateSelector.click();
    }

    public void clickGate2(){
        link2.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        gateSelector.click();
    }

    public void clickSubmit(){
        submitButton.click();
    }


    public void takeSS() throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("src/main/resources/screenshots/Level-6.png"));
    }
    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            Level6 Level6 = new Level6(driver);
            String handle1 = Level6.openLevel6();
            Level6.newTab();
            Level6.openLevel6();
            Level6.clickGate1();
            driver.close();
            driver.switchTo().window((handle1));
            Level6.newTab();
            Level6.openLevel6();
            Level6.clickGate2();
            driver.close();
            driver.switchTo().window((handle1));
            Level6.takeSS();
            Level6.clickSubmit();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
