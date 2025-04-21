package com.revature;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Level2 {

    WebDriver driver;



        @FindBy(xpath = "/html/body/dl/dd[1]")
        WebElement dropCount;
        @FindBy(xpath = "/html/body/dl/dd[2]")
        WebElement cboxCount;
        @FindBy(xpath = "/html/body/dl/dd[3]")
        WebElement radioCount;
        @FindBy(xpath = "/html/body/dl/dd[4]")
        WebElement dateToAdd;
        @FindBy(xpath = "/html/body/dl/dd[5]")
        WebElement buttonCount;



        @FindBy(xpath = "/html/body/form/select")
        WebElement dropdown;

        @FindBy(name = "checkbox1")
        WebElement checkbox1;
        @FindBy(name = "checkbox2")
        WebElement checkbox2;
        @FindBy(name = "checkbox3")
        WebElement checkbox3;

        @FindBy(xpath = "/html/body/form/fieldset[2]/input[1]")
        WebElement radio1;
        @FindBy(xpath = "/html/body/form/fieldset[2]/input[2]")
        WebElement radio2;
        @FindBy(xpath = "/html/body/form/fieldset[2]/input[3]")
        WebElement radio3;

        @FindBy(xpath = "/html/body/form/input")
        WebElement dateInput;

        @FindBy(xpath = "/html/body/form/button[1]")
        WebElement button1;
        @FindBy(xpath = "/html/body/form/button[2]")
        WebElement button2;
        @FindBy(xpath = "/html/body/form/button[3]")
        WebElement button3;


    public Level2(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openLevel2(){
        driver.get("C:\\Users\\Josh\\Desktop\\inFormed-Josh\\Important Resources\\InFormed\\level-2.html");
    }

    public void selectDropdown(){
        String count = dropCount.getText();
        Select select = new Select(dropdown);
        switch (count){
            case "1":
                select.selectByValue("1");
                break;
            case "2":
                select.selectByValue("2");
                break;
            case "3":
                select.selectByValue("3");
                break;
        }
    }

    public void selectCheckbox(){
        String count = cboxCount.getText();
        switch (count) {
            case "1":
                checkbox1.click();
                break;
            case "2":
                checkbox2.click();
                break;
            case "3":
                checkbox3.click();
                break;
            case "All of them":
                checkbox1.click();
                checkbox2.click();
                checkbox3.click();
                break;
        }
    }

    public void selectRadio(){
        String count = radioCount.getText();
        switch (count) {
            case "1":
                radio1.click();
                break;
            case "2":
                radio2.click();
                break;
            case "3":
                radio3.click();
                break;
        }
    }

    public void enterDate(){
        String full = dateToAdd.getText();
        String year = full.substring(0,4);
        String month = full.substring(5,7);
        String day = full.substring(8,10);
        dateInput.sendKeys(month+day+year);
    }

    public void selectButton(){
        String count = buttonCount.getText();
        System.out.println(count);
        switch (count) {
            case "1":
                button1.click();
                break;
            case "2":
                button2.click();
                break;
            case "3":
                button3.click();
                break;
        }
    }





    public void takeSS() throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("src/main/resources/screenshots/Level-2.png"));
    }

    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            Level2 Level2 = new Level2(driver);
            Level2.openLevel2();
            Level2.selectDropdown();
            Level2.selectCheckbox();
            Level2.selectRadio();
            Level2.enterDate();
            Level2.takeSS();
            Level2.selectButton();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();

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

