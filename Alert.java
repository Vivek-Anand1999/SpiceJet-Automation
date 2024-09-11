package com.vivek;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPage {
    public static void responseAlert(WebDriver driver) {
        String name = "Rahul";
        driver.findElement(By.id("name")).sendKeys(name);
        // driver.findElement(By.id("alertbtn")).click();
        driver.findElement(By.id("confirmbtn")).click();
        System.out.println(driver.switchTo().alert().getText());
        // driver.switchTo().alert().accept();//!this for accept /ok/yes or any positive
        // approach
        driver.switchTo().alert().dismiss();// ! this is for cancle no/ or any negative approach

    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "/home/vivek/Downloads/chromedriver-linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // ! Method call strted
        responseAlert(driver);

    }

}
