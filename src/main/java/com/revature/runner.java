package com.revature;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class runner {
    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            Level1 Level1 = new Level1(driver);
            Level1.openLevel1();
            Level1.submitRandomName();
            driver.switchTo().alert().accept();
            Level1.takeSS();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }

    }
}

