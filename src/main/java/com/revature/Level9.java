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

public class Level9 {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"nameInput\"]")
    WebElement nameInput;

    @FindBy(xpath = "//*[@id=\"submitBtn\"]")
    WebElement submitButton;

    public Level9(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String openLevel9 (){
        driver.get("C:\\Users\\Josh\\Desktop\\inFormed-Josh\\Important Resources\\InFormed\\level-9.html");
        System.out.println(driver.getWindowHandle());
        return driver.getWindowHandle();
    }

    public void submit(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(nameInput));
        nameInput.sendKeys("abc");
    }

    public void clickSubmit(){
        submitButton.click();
    }

    public void takeSS() throws IOException {
        java.io.File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("src/main/resources/screenshots/Level-9.png"));
    }
    

    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            Level9 Level9 = new Level9(driver);
            Level9.openLevel9();
            Level9.submit();
            Level9.takeSS();
            Level9.clickSubmit();


        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
